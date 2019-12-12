package com.revature.caliber.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BATCH_ID_SEQUENCE")
	@SequenceGenerator(name = "BATCH_ID_SEQUENCE", sequenceName = "BATCH_ID_SEQUENCE")
	private int batchId;
	
	@NotNull
	@Column(name="TRAINER")
	private String trainer;
	
	@NotNull
	@Column(name="START_DATE")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date startDate;
	
	@Column(name="WEEKS")
	private int weeks;
	
	

	public Batch(int batchId, String trainer, Date startDate, int weeks) {
		super();
		this.batchId = batchId;
		this.trainer = trainer;
		this.startDate = startDate;
		this.weeks = weeks;
	}

	public Batch(int batchId, String trainer, Date startDate) {
		super();
		this.batchId = batchId;
		this.trainer = trainer;
		this.startDate = startDate;
	}

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
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

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	
}
