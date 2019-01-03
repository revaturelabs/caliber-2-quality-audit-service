package com.revature.caliber.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Note;
import com.revature.caliber.beans.NoteType;
import com.revature.caliber.beans.QCStatus;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.beans.TraineeFlag;
import com.revature.caliber.dao.NoteRepository;
import com.revature.caliber.intercomm.TraineeClient;

import feign.RetryableException;

@Service
public class EvaluationService {
	
	private static final Logger log = Logger.getLogger(EvaluationService.class);
	
	@Autowired
    NoteRepository noteRepo;
	@Autowired
	TraineeClient traineeClient;

	/**
	 * 
	 * @param note
	 * Auto flags a trainee if they receive more than 1 "Poor" QC status or 
	 * an "Average" directly followed by a "Poor".
	 * 
	 */
	public void checkIfTraineeShouldBeFlagged(Note note) {
		if (note != null && note.getType().equals(NoteType.QC_TRAINEE)) {
			// Cannot be auto flagged on week 1
			if (note.getWeek() < 2) return;
//			// Return if trainee was already auto flagged
//			else if (note.getTrainee().getFlagNotes().contains("Trainee was automatically flagged by Caliber")) return;

			// Retrieve a list of all notes in week ASC order
			List<Note> notes = noteRepo.findByTraineeId(note.getTraineeId(), new Sort("week"));
			
			boolean consecutive = false;
			int reds = 0;
			try {				// Current week
				consecutive = (notes.get(note.getWeek() - 1).getQcStatus().equals(QCStatus.Poor))
						// Previous week
						&& (notes.get(note.getWeek() - 2).getQcStatus().equals(QCStatus.Poor)
								|| notes.get(note.getWeek() - 2).getQcStatus().equals(QCStatus.Average)) ? true : false;
				Iterator<Note> itr = notes.iterator();
				while (itr.hasNext()) {
					if (itr.next().getQcStatus() == QCStatus.Poor) {
						if (++reds == 2) break;
					}
				}				
				if (consecutive || (reds >= 2)) {					
					// save the flag status in database
					Trainee trainee = note.getTrainee();
					trainee.setFlagStatus(TraineeFlag.RED);
					// concat a generated flag message at the end of the current trainee notes
					if (trainee.getFlagNotes() != null
							&& !trainee.getFlagNotes().contains("Trainee was automatically flagged by Caliber"))
						trainee.setFlagNotes("Trainee was automatically flagged by Caliber. " + trainee.getFlagNotes());
					else
						trainee.setFlagNotes("Trainee was automatically flagged by Caliber. ");

					traineeClient.updateTrainee(trainee);
				} 			
				else {
					// remove the flag status in database
					Trainee trainee = note.getTrainee();
					trainee.setFlagStatus(TraineeFlag.NONE);
					traineeClient.updateTrainee(trainee);
				}
			} catch(RetryableException e) {
				log.debug("Failed to connect to User Service");
			} catch (Exception e) {
				log.debug("Failed to autoflag associate with note: " + note);
				log.debug(e);
			}
		}
	}
	
	
	public void calculateAverage(short weekId, Integer batchId) {
		if(batchId !=  null) {
			Note overallNote = noteRepo.findQCBatchNotes(batchId, weekId, NoteType.QC_BATCH);
			double average = 0.0f;
			List<Note> traineeNoteList = noteRepo.findQCNotesByBatchAndWeek(batchId, weekId, NoteType.QC_TRAINEE);
			int denominator = traineeNoteList.size();
			for(Note note : traineeNoteList) {
				switch(note.getQcStatus()) {
				case Superstar:
					average += 4;
					break;
				case Good:
					average += 3;
					break;
				case Average:
					average += 2;
					break;
				case Poor:
					average += 1;
					break;
				default:
					denominator--;
				}
			}
			if(denominator != 0) {
				average /= denominator;
			}else {
				average = 0.0f;
			}
			if(average > 2.5) {
				overallNote.setQcStatus(QCStatus.Good);
			} else if(average >= 2 && average <= 2.5) {
				overallNote.setQcStatus(QCStatus.Average);
			} else if (average > 0 && average < 2) {
				overallNote.setQcStatus(QCStatus.Poor);
			} else {
				overallNote.setQcStatus(QCStatus.Undefined);
			}
			log.trace("The calculated average is: " + overallNote.getQcStatus());
			noteRepo.save(overallNote);
		}
	}


}
