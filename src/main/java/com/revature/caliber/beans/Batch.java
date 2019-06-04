package com.revature.caliber.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The type Batch.
 */
@Entity
@Table(name = "CALIBER_BATCH")
//@ValidBatch
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Batch implements Serializable {

	private static final long serialVersionUID = 2916173221333913998L;
	
	@Id
	@Column(name="BATCH_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer batchId;
	
	@NotNull
	@Column(name="TRAINER")
	private String trainer;
	
	@NotNull
	@Column(name="START_DATE")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date startDate;
	
	@Column(name="WEEKS")
	private Integer weeks;
	
	

	public Batch(Integer batchId, String trainer, Date startDate, Integer weeks) {
		super();
		this.batchId = batchId;
		this.trainer = trainer;
		this.startDate = startDate;
		this.weeks = weeks;
	}

	public Batch(Integer batchId, String trainer, Date startDate) {
		super();
		this.batchId = batchId;
		this.trainer = trainer;
		this.startDate = startDate;
	}

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}
	
}
