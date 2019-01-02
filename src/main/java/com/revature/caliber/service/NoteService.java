package com.revature.caliber.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.BatchEntity;
import com.revature.caliber.beans.Note;
import com.revature.caliber.beans.Trainee;
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
	
	/**
	 * The repository is responsible for interacting with the note table
	 */
	@Autowired
	NoteRepository repo;
	
	@Autowired
	private TraineeClient tClient;
	
	/**
	 * 
	 * @return notes
	 */
	public List<Note> getAllNotes() {
		return repo.findAll();
	}
	
	/**
	 * Save note
	 * @param n
	 * @return
	 */
	public Note createNote(Note n) {
		return repo.save(n);
	}
	
	/**
	 * 
	 * @param batch
	 * @return A list of new QC notes for all non-dropped associates in the specified batch. The order of the list is
	 * 		   randomized and a new overall batch note is appended to the end.
	 */
	public List<Note> createBatchNotes(BatchEntity batch){
		// Retrieve batchId and week number from batch entity
		int batchId = batch.getBatchId();
		int weekInt = batch.getWeeks();
		short week = (short) weekInt;
		List<Note> notes = new ArrayList<Note>();
		try {
			// Use Feign Client to retrieve list of trainees from the User Service
			ResponseEntity<List<Trainee>> response = tClient.findAllByBatch(batchId);
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
		}catch(RetryableException e) {
			e.printStackTrace();
			return null;
		}
		// Shuffle list of notes so names are displayed in random order on the client side
		Collections.shuffle(notes);
		// Create an "overall feedback" note and append to the end of the list
		Note batchNote = new Note(week, batchId);
		batchNote = repo.save(batchNote);
		notes.add(batchNote);
		return notes;
	}
	
	/**
	 * Delete a note
	 * @param id
	 */
	public void deleteNote(Integer id) {
		repo.delete(id);
	}
	
	public Note findById(Integer id) {
		return repo.findOne(id);
	}
	
	/**
	 * Update a note
	 * @param n
	 * @return
	 */
	public Note updateNote(Note n) {
		return repo.save(n);
	}
	
	
	public int updateWeekForNote(short week, int id) {
		return repo.updateWeekForNote(week, id);
	}
	
	
	public List<Note> findByBatchAndWeek(Integer batchId, Short week) {
		return repo.findByBatchAndWeek(batchId, week);
	}


}
