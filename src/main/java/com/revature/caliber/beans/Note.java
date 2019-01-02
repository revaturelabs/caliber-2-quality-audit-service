package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


/**
 * 
 *
 */
@Entity
@Table(name = "CALIBER_NOTE")
public class Note implements Serializable{

	private static final long serialVersionUID = 4960654794116385953L;

	@Id
	@Column(name = "NOTE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_ID_SEQUENCE")
	@SequenceGenerator(name = "NOTE_ID_SEQUENCE", sequenceName = "NOTE_ID_SEQUENCE")
	private int noteId;

	@Length(min=0, max=4000)
	@Column(name = "NOTE_CONTENT")
	private String content;

	@Min(value=1)
	@Column(name = "WEEK_NUMBER")
	private short week;

	/**
	 * Will be null if the note is individual traineeId feedback
	 */
	@Column(name = "BATCH_ID", nullable = true)
	private int batchId;

	/**
	 * Will be null if the note is overall batchId feedback
	 */
	@Column(name = "TRAINEE_ID", nullable = true)
	private int traineeId;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "NOTE_TYPE")
	private NoteType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "QC_STATUS", nullable = true)
	private QCStatus qcStatus;

	public Note() {
		super();	
	}

	public Note(int noteId, String content, short week, int batchIdId, int traineeIdId,
			NoteType type, QCStatus qcStatus) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.week = week;
		this.batchId = batchIdId;
		this.traineeId = traineeIdId;
		this.type = type;
		this.qcStatus = qcStatus;
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

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", content=" + content + ", week=" + week + ", batchId=" + batchId
				+ ", traineeId=" + traineeId + ", type=" + type + ", qcStatus=" + qcStatus + "]";
	}
	
	

	
}

