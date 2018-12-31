package com.revature.caliber.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Trainee implements Serializable{

	private static final long serialVersionUID = 2324102408079648929L;
	
	private int traineeId;
	private String name;
	private TrainingStatus trainingStatus;
	private Batch batch;
	private TraineeFlag flagStatus;
	private String flagNotes;
	
	private Set<Note> notes;
	
	public Trainee() {
		super();
		this.flagStatus = TraineeFlag.NONE;
	}

	public Trainee(int traineeId, String resourceId, String name, TrainingStatus trainingStatus, Batch batch,
			TraineeFlag flagStatus, String flagNotes, Set<Note> notes) {
		super();
		this.traineeId = traineeId;
		this.name = name;
		this.trainingStatus = trainingStatus;
		this.batch = batch;
		this.flagStatus = flagStatus;
		this.flagNotes = flagNotes;
		this.notes = notes;
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

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
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

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", trainingStatus="
				+ trainingStatus + ", batch=" + batch + ", flagStatus=" + flagStatus + ", flagNotes=" + flagNotes
				+ ", notes=" + notes + "]";
	}
	

	
	

}
