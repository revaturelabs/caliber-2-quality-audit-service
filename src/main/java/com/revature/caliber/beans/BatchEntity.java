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

@Entity
@Table(name="CALIBER_BATCH")
public class BatchEntity implements Serializable {
	
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

	public BatchEntity() {
		super();
	}

	public BatchEntity(Integer batchId, String trainer, Date startDate) {
		super();
		this.batchId = batchId;
		this.trainer = trainer;
		this.startDate = startDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BatchEntity [batchId=" + batchId + ", trainer=" + trainer + ", startDate=" + startDate + "]";
	}
	
	

}
