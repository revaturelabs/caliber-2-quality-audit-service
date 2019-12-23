package com.revature.caliber.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		result = prime * result + weeks;
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
		Batch other = (Batch) obj;
		if (batchId != other.batchId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		if (weeks != other.weeks)
			return false;
		return true;
	}
}
