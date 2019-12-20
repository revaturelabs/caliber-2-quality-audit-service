package com.revature.caliber.beans;

import java.sql.Timestamp;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((flagAuthor == null) ? 0 : flagAuthor.hashCode());
		result = prime * result + ((flagNoteTimeStamp == null) ? 0 : flagNoteTimeStamp.hashCode());
		result = prime * result + ((flagNotes == null) ? 0 : flagNotes.hashCode());
		result = prime * result + ((flagStatus == null) ? 0 : flagStatus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + traineeId;
		result = prime * result + ((trainingStatus == null) ? 0 : trainingStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		if (batchId != other.batchId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flagAuthor == null) {
			if (other.flagAuthor != null)
				return false;
		} else if (!flagAuthor.equals(other.flagAuthor))
			return false;
		if (flagNoteTimeStamp == null) {
			if (other.flagNoteTimeStamp != null)
				return false;
		} else if (!flagNoteTimeStamp.equals(other.flagNoteTimeStamp))
			return false;
		if (flagNotes == null) {
			if (other.flagNotes != null)
				return false;
		} else if (!flagNotes.equals(other.flagNotes))
			return false;
		if (flagStatus != other.flagStatus)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (traineeId != other.traineeId)
			return false;
		if (trainingStatus != other.trainingStatus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", trainingStatus="
				+ trainingStatus + ", batchId=" + batchId + ", flagStatus=" + flagStatus + ", flagNotes=" + flagNotes
				+ ", flagAuthor=" + flagAuthor + ", flagNoteTimeStamp=" + flagNoteTimeStamp + "]";
	}

}
