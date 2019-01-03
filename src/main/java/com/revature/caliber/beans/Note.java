package com.revature.caliber.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import org.hibernate.validator.constraints.Length;

/**
 * 
 *
 */
@Entity
@Table(name = "CALIBER_NOTE")
@DynamicUpdate
public class Note implements Serializable {

	private static final long serialVersionUID = 4960654794116385953L;

	@Id
	@Column(name = "NOTE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_ID_SEQUENCE")
	@SequenceGenerator(name = "NOTE_ID_SEQUENCE", sequenceName = "NOTE_ID_SEQUENCE")
	private int noteId;

	@NotNull
	@Length(min = 0, max = 4000)
	@Column(name = "NOTE_CONTENT", nullable = true)
	private String content;

	@NotNull
	@Min(value = 1)
	@Column(name = "WEEK_NUMBER")
	private short week;
	/**
	 * Will be null if the note is individual traineeId feedback
	 */
	@Column(name = "BATCH_ID", nullable = true)
	private int batchId;

	/**
	 * Will be null if the note is overall batch feedback
	 */
	@Transient
	private Trainee trainee;

	@Column(name = "TRAINEE_ID", nullable = true)
	private int traineeId;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "NOTE_TYPE")
	private NoteType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "QC_STATUS", nullable = true)
	private QCStatus qcStatus;

	@Column(name = "UPDATE_TIME")
	private Timestamp updateTime;

	@NotNull
	@Column(name = "LAST_SAVED_BY")
	private int lastSavedBy;

	public Note() {
		super();
		this.updateTime = new Timestamp(System.currentTimeMillis());
		this.lastSavedBy = 1;
	}

	public Note(int noteId, String content, short week, int batchIdId, int traineeIdId, NoteType type,
			QCStatus qcStatus) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.week = week;
		this.batchId = batchIdId;
		this.traineeId = traineeIdId;
		this.type = type;
		this.qcStatus = qcStatus;
		this.updateTime = new Timestamp(System.currentTimeMillis());
		this.lastSavedBy = 1;
	}

	/**
	 * 
	 * @param week
	 * @param batchId
	 * 
	 *                Create overall batch note per week.
	 * 
	 */
	public Note(short week, int batchId) {
		this.content = " ";
		this.week = week;
		this.batchId = batchId;
		this.type = NoteType.QC_BATCH;
		this.qcStatus = QCStatus.Undefined; // "Overall Feedback"
		this.updateTime = new Timestamp(System.currentTimeMillis());
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public short getWeek() {
		return week;
	}

	public void setWeek(short week) {
		this.week = week;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public NoteType getType() {
		return type;
	}

	public void setType(NoteType type) {
		this.type = type;
	}

	public QCStatus getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(QCStatus qcStatus) {
		this.qcStatus = qcStatus;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + noteId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((qcStatus == null) ? 0 : qcStatus.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + week;
		result = prime * result + batchId;
		result = prime * result + traineeId;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return super.hashCode();
	}

	public String getcreationTime() {
		return updateTime.toString();
	}

	public void setcreationTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getLastSavedBy() {
		return lastSavedBy;
	}

	public void setLastSavedBy(int lastSavedBy) {
		this.lastSavedBy = lastSavedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;

	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + noteId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((qcStatus == null) ? 0 : qcStatus.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + week;
		result = prime * result + batchId;
		result = prime * result + traineeId;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + lastSavedBy;
		return super.hashCode();

	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", content=" + content + ", week=" + week + ", batchId=" + batchId
				+ ", trainee=" + trainee + ", traineeId=" + traineeId + ", type=" + type + ", qcStatus=" + qcStatus
				+ ", updateTime=" + updateTime + "]";
	}

}
