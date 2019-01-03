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

import com.revature.caliber.beans.BatchEntity;
import com.revature.caliber.beans.Note;
import com.revature.caliber.service.NoteService;

/**
 * Controllers for handling all requests having to do with notes.
 * 
 * @author thienle
 *
 */
@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "*")
public class NoteController {

	private static final Logger log = Logger.getLogger(NoteController.class);

	@Autowired
	private NoteService service;

	/**
	 * Handles get request for returning all notes
	 * 
	 * @return
	 */
	@GetMapping("/notes")
	public List<Note> getAllNotes() {

		log.trace("in notes: Looking for note");
		return service.getAllNotes();
	}

	/**
	 * 
	 * @param id
	 * @return a note based on noteId
	 */
	@GetMapping(value = "/note/{id}")
	public Note getNote(@PathVariable Integer id) {
		log.trace("IN FIND ONE NOTE");
		return service.findById(id);
	}
	
	@GetMapping(value = "/notes/{batch}/{week}")
	public List<Note> getNotesByBatchAndWeek(@PathVariable Integer batch, @PathVariable Short week){
		return service.findByBatchAndWeek(batch, week);
	}

	/**
	 * Handles post request for creating a note
	 * 
	 * @param note
	 * @return The created note as well as an OK status code
	 */
//	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Note> createNote(@RequestBody Note note) {
//		log.debug("CREATING NOTE: " + note);
//		note = service.createNote(note);
//		if (note == null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		} else {
//			return new ResponseEntity<>(note, HttpStatus.CREATED);
//		}
//	}
	
	@PostMapping(path = "/note/create-batch-notes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Note>> createBatchNotes(@RequestBody BatchEntity batch){		
		List<Note> notes = service.createBatchNotes(batch);
		if (notes == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<>(notes, HttpStatus.CREATED);
		}
	}

	/**
	 * Updating note
	 * 
	 * @param note
	 * @return
	 */
	@PutMapping(path = "/update")
	public ResponseEntity<Note> updateNote(@RequestBody Note note) {
		log.debug("Updating note: " + note);
		note = service.updateNote(note);

		if (note == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(note, HttpStatus.CREATED);
		}
	}
	
	/**
	 * Update partial columns of note table
	 * @param note
	 * @return
	 */
	@PutMapping(path = "/updateWeek")
	@Transactional
	public int updateWeekForNote(@RequestBody Note note) {
		log.debug("Updating note: " + note);
	
		return service.updateWeekForNote(note.getWeek(), note.getNoteId());

	}


}
