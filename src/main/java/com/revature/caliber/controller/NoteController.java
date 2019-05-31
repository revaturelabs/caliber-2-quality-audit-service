package com.revature.caliber.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.BatchEntity;
import com.revature.caliber.beans.Note;
import com.revature.caliber.beans.NoteType;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.intercomm.BatchClient;
import com.revature.caliber.service.NoteService;

/**
 * Controllers for handling all requests having to do with notes.
 * 
 * @author
 *
 */
@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "*")
public class NoteController {

	private static final Logger log = Logger.getLogger(NoteController.class);

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private BatchClient batchClient;

	/**
	 * 
	 * @return all Notes in the database.
	 */
	@GetMapping("/notes")
	public ResponseEntity<List<Note>> getAllNotes() {
		log.trace("IN AUDIT: RETURNING ALL NOTES");
		List<Note> notes = noteService.getAllNotes();
		if (notes == null) {
			return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
		}
	}

	/**
	 * get request to return a note based on ID.
	 * 
	 * @param id - the note ID.
	 * @return a note based on noteId.
	 */
	@GetMapping(value = "/notes/{id}")
	public ResponseEntity<Note> getNote(@PathVariable Integer id) {
		log.trace("IN AUDIT: FIND ONE NOTE");
		Note note = noteService.findById(id);
		if (note == null) {
			return new ResponseEntity<Note>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Note>(note, HttpStatus.OK);
		}
	}

	/**
	 * 
	 * @param batchId.
	 * @param week number.
	 * @return a list of associate notes according to batch and week.
	 */
	@GetMapping(value = "/notes/{batchId}/{week}")
	public ResponseEntity<List<Note>> getNotesByBatchAndWeek(@PathVariable Integer batchId, @PathVariable Short week) {
		List<Note> notes = noteService.findQCNotesByBatchAndWeek(batchId, week);
		if (notes == null) {
			return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
		}
		
		// If we don't find any notes, try to create them.
		// This will not create anything if we try to get notes for a week greater
		// than the number of weeks in a batch.
		if (notes.size() == 0) {
			BatchEntity batch = batchClient.getBatchById(batchId);
			notes = noteService.createBatchNotesForWeek(batch, week);
			if (notes == null) {
				return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
			}
			// drop batch note from list
			notes.removeIf(note->note.getType()==NoteType.QC_BATCH);
		}
		
		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param traineeId.
	 * @return a list QC notes for specified trainee.
	 */
	@GetMapping(value = "/notes/trainee/{traineeId}")
	public ResponseEntity<List<Note>> getTraineeNotesById(@PathVariable Integer traineeId) {
		List<Note> notes = noteService.findQCTraineeNotesById(traineeId);
		if (notes == null) {
			return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
		}
	}

	/**
	 * 
	 * @param batch ID.
	 * @param week number.
	 * @return the overall QC batch note for the give week.
	 */
	@GetMapping(value = "/notes/overall/{batch}/{week}")
	public ResponseEntity<Note> getOverallNoteByBatchAndWeek(@PathVariable Integer batch, @PathVariable Short week) {
		Note note = noteService.findOverallNoteByBatchAndWeek(batch, week);
		if (note == null) {
			return new ResponseEntity<Note>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Note>(note, HttpStatus.OK);
		}
	}
	
	/**
	 * 
	 * @param batch - a BatchEntity that contains a batchId and week number.
	 * @return A list of new QC notes for all non-dropped associates in the specified batch as well
	 * 			as a an overall batch note appended at the end of the list.
	 */
	@PostMapping(path = "/notes/create-batch-notes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Note>> createBatchNotes(@RequestBody BatchEntity batch) {
		List<Note> notes = noteService.createBatchNotesForWeek(batch, batch.getWeeks());
		if (notes == null) {
			return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<List<Note>>(notes, HttpStatus.CREATED);
		}
	}
	/**
	 * In the case that a new trainee is added to a batch mid-training, QC notes for that trainee should be
	 * created for each week the batch has gone through.
	 * 
	 * @param batch - a BatchEntity that contains a batchId and number of weeks.
	 * @return A list of new QC notes by week for the new trainee in the specified batch.
	 */
	@PostMapping(path = "/notes/create-new-trainee-notes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Note>> createNewTraineeNotes(@RequestBody Trainee t) {
		List<Note> notes = noteService.createNewTraineeNotes(t);
		if (notes == null) {
			return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<List<Note>>(notes, HttpStatus.CREATED);
		}
	}
	
	/**
	 * 
	 * @param Note to be updated.
	 * @return Overall batch QC note.
	 */
	@PutMapping(path = "/update")
	@Transactional
	public ResponseEntity<Note> updateNote(@RequestBody Note note) {
		log.debug("IN AUDIT, UPDATING NOTE: " + note);
		note = noteService.updateNote(note);
		if (note == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(note, HttpStatus.ACCEPTED);
		}
	}


}
