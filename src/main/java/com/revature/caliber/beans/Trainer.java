package com.revature.caliber.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Trainer.
 */
public class Trainer implements Serializable{

	private static final long serialVersionUID = 2886418048122511755L;
	
	private int trainerId;
	private String name;

	public Trainer() {
		super();
	}

	public Trainer(int trainerId, String name, TrainerRole tier, Set<Batch> batches) {
		super();
		this.trainerId = trainerId;
		this.name = name;
	}


	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + "]";
	}
	
	

}
