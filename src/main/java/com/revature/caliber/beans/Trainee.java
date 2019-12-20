package com.revature.caliber.beans;

import java.sql.Timestamp;
import java.util.Objects;

public class Trainee {
	
	private int traineeId;
	private String name;
	private TrainingStatus trainingStatus;
	private int batchId;
	private String email;		// Need in order to update trainee in User Service
	private TraineeFlag flagStatus;
	private String flagNotes;
	private Trainer flagAuthor;	// Will be null until login page is implemented
	private Timestamp flagNoteTimeStamp;
		
	public Trainee() {
		super();
		this.flagStatus = TraineeFlag.NONE;
	}

	public Trainee(int traineeId, String name, TrainingStatus trainingStatus, int batchId,
			TraineeFlag flagStatus, String flagNotes, Trainer flagAuthor, Timestamp flagNoteTimeStamp) {
		super();
		this.traineeId = traineeId;
		this.name = name;
		this.trainingStatus = trainingStatus;
		this.batchId = batchId;
		this.flagStatus = flagStatus;
		this.flagNotes = flagNotes;
		this.flagAuthor = flagAuthor;
		this.flagNoteTimeStamp = flagNoteTimeStamp;
	}


	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TrainingStatus getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(TrainingStatus trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public TraineeFlag getFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(TraineeFlag flagStatus) {
		this.flagStatus = flagStatus;
	}

	public String getFlagNotes() {
		return flagNotes;
	}

	public void setFlagNotes(String flagNotes) {
		this.flagNotes = flagNotes;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Trainer getFlagAuthor() {
		return flagAuthor;
	}

	public void setFlagAuthor(Trainer flagAuthor) {
		this.flagAuthor = flagAuthor;
	}

	public Timestamp getFlagNoteTimeStamp() {
		return flagNoteTimeStamp;
	}

	public void setFlagNoteTimeStamp(Timestamp flagNoteTimeStamp) {
		this.flagNoteTimeStamp = flagNoteTimeStamp;
	}
	
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", trainingStatus="
				+ trainingStatus + ", batchId=" + batchId + ", flagStatus=" + flagStatus + ", flagNotes=" + flagNotes
				+ ", flagAuthor=" + flagAuthor + ", flagNoteTimeStamp=" + flagNoteTimeStamp + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Trainee trainee = (Trainee) o;
		return traineeId == trainee.traineeId &&
						batchId == trainee.batchId &&
						Objects.equals(name, trainee.name) &&
						trainingStatus == trainee.trainingStatus &&
						Objects.equals(email, trainee.email) &&
						flagStatus == trainee.flagStatus &&
						Objects.equals(flagNotes, trainee.flagNotes) &&
						Objects.equals(flagAuthor, trainee.flagAuthor) &&
						Objects.equals(flagNoteTimeStamp, trainee.flagNoteTimeStamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(traineeId, name, trainingStatus, batchId, email, flagStatus, flagNotes, flagAuthor, flagNoteTimeStamp);
	}
}
