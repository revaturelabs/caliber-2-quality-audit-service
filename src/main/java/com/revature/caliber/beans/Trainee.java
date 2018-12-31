package com.revature.caliber.beans;

import java.util.Set;



public class Trainee {

	
	private int traineeId;
	private String resourceId;
	private String name;
	private String email;
	private TrainingStatus trainingStatus;
	private Integer batchId;
	private Batch batch;
	private TraineeFlag flagStatus;
	private String flagNotes;
	
	
	public Trainee() {
		super();
		this.flagStatus = TraineeFlag.NONE;
	}

	public Trainee(int traineeId, String resourceId, String name, TrainingStatus trainingStatus, Integer batchId,
			TraineeFlag flagStatus, String flagNotes) {
		super();
		this.traineeId = traineeId;
		this.resourceId = resourceId;
		this.name = name;
		this.trainingStatus = trainingStatus;
		this.batchId = batchId;
		this.flagStatus = flagStatus;
		this.flagNotes = flagNotes;
	
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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

	
	
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", resourceId=" + resourceId + ", name=" + name + ", trainingStatus="
				+ trainingStatus + "batchId=" + batchId + ", batch=" + batch + ", flagStatus=" + flagStatus + ", flagNotes=" + flagNotes
				+  "]";
	}
	

	
	

}
