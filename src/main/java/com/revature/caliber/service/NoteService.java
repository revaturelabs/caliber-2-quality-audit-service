package com.revature.caliber.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.BatchEntity;
import com.revature.caliber.beans.Note;
import com.revature.caliber.beans.NoteType;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.beans.TraineeFlag;
import com.revature.caliber.beans.TrainingStatus;
import com.revature.caliber.dao.NoteRepository;
import com.revature.caliber.intercomm.TraineeClient;

import feign.RetryableException;

/**
 * Implementing the business logic for handling Note objects
 *
 */
@Service
public class NoteService {

	private static final Logger log = Logger.getLogger(NoteService.class);
	
	/**
	 * The repository is responsible for interacting with the note table
	 */
	@Autowired
	NoteRepository repo;	
	@Autowired
	private TraineeClient traineeClient;
	@Autowired
	private EvaluationService evaluationService;
	
	/**
	 * 
	 * @return notes
	 */
	public List<Note> getAllNotes() {
		return repo.findAll();
	}
	
	
	/**
	 * Creates empty QC notes for the entire batch, including an overall batch note.
	 * 
	 * @param batch - a BatchEntity that contains a batchId and week number.
	 * @return A list of new QC notes for all non-dropped associates in the specified batch as well
	 * 			as a an overall batch note appended at the end of the list.
	 */
	public List<Note> createBatchNotes(BatchEntity batch){
		// Retrieve batchId and week number from batch entity
		int batchId = batch.getBatchId();
		int weekInt = batch.getWeeks();
		short week = (short) weekInt;
		List<Note> notes = new ArrayList<Note>();
		try {
			// Use Feign Client to retrieve list of trainees from the User Service
			ResponseEntity<List<Trainee>> response = traineeClient.findAllByBatch(batchId);
			if(response != null && response.hasBody()) {
				List<Trainee> trainees = response.getBody();
				Iterator<Trainee> itr = trainees.iterator();
				Trainee t = new Trainee();
				// Create and save empty QC note for each trainee
				while (itr.hasNext()) {
					t = itr.next();
					if (t.getTrainingStatus() != TrainingStatus.Dropped) {
						Note n = new Note(week, batchId, t);
						n = repo.save(n);
						notes.add(n);
					}
				}
			}
			else {
				return null;
			}
		} catch(RetryableException e) {
			e.printStackTrace();
			return null;
		}
		// Create an "overall batch feedback" note and append to the end of the list
		Note overallNote = new Note(week, batchId);
		overallNote = repo.save(overallNote);
		notes.add(overallNote);
		return notes;
	}
	
	
	public Note findById(Integer id) {
		return repo.findOne(id);
	}

	/**
	 * 
	 * Updates a note. If it's a QC Trainee note, recalculate the batch's overall average QC status
	 * and checks if the trainee should be auto flagged. The note's update time is also updated.
	 * 
	 * @param note - the Note to be updated.
	 * @return the updated Note.
	 */
	public Note updateNote(Note note) {
		// Save trainee object
		Trainee trainee = note.getTrainee();	
		// If note is a trainee note, update overall note and check for auto flagging
		if(note.getType() == NoteType.QC_TRAINEE) {
			log.trace("Updating note: " + note);
			evaluationService.calculateAverage(note.getWeek(), new Integer(note.getBatchId()));
			// Updates trainee if they were auto flagged
			trainee = evaluationService.checkIfTraineeShouldBeFlagged(note);
			log.trace("Updated trainee: " + trainee);
			note.setTrainee(trainee);
		}
		// update the updateTime
		note.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		note = repo.save(note);
		// re-add trainee object to note to send back to client
		note.setTrainee(trainee);
		return note;
	}
	
	/**
	 * 
	 * @param batchId
	 * @param week
	 * @return Randomized list of QC Trainee notes by batchId and week number.
	 */
	public List<Note> findQCNotesByBatchAndWeek(Integer batchId, Short week) {
		List<Note> notes = repo.findQCNotesByBatchAndWeek(batchId, week, NoteType.QC_TRAINEE);
		List<Trainee> trainees = traineeClient.findAllByBatch(batchId).getBody();
		for (Note n: notes) {
			for (Trainee t: trainees) {
				if (n.getTraineeId() == t.getTraineeId()) {
					// set the note's trainee object
					n.setTrainee(t);
				}
			}
		}
		// Shuffle list of notes so names are displayed in random order on the client side
		Collections.shuffle(notes);
		return notes;
	}
	
	/**
	 * 
	 * @param traineeId
	 * @return a list QC notes for specified trainee.
	 */
	public List<Note> findQCTraineeNotesById(Integer traineeId){
		return repo.findByTraineeId(traineeId, new Sort("week"));
	}
	
	/**
	 * 
	 * @param batchId
	 * @param week
	 * @return the overall QC batch note for the give week.
	 */
	public Note findOverallNoteByBatchAndWeek(Integer batchId, Short week) {
		return repo.findQCBatchNotes(batchId, week, NoteType.QC_BATCH);
	}
	
	

}
