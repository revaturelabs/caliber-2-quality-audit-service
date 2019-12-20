package com.revature.caliber.beans;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "NOTE_ID_SEQUENCE")
	@SequenceGenerator(name = "NOTE_ID_SEQUENCE", sequenceName = "NOTE_ID_SEQUENCE")
	private int noteId;

	@Length(min=0, max=4000)
	@Column(name = "NOTE_CONTENT", nullable = true)
	private String content;

	@NotNull
	@Min(value = 1)
	@Column(name = "WEEK_NUMBER")
	private short week;
	/**
	 * Will be null if the note is individual traineeId feedback
	 */
	@Column(name = "BATCH_ID")
	private int batchId;

	/**
	 * Will be null if the note is overall batch feedback. Need the object to send to 
	 * the client, but don't need to save the whole object into this service's database.
	 */
	@Transient
	private Trainee trainee;
	
	/**
	 * Will be 0 if the note is overall batch feedback
	 */
	@Column(name = "TRAINEE_ID", nullable = true)
	private int traineeId;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "NOTE_TYPE")
	private NoteType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "TECHNICAL_STATUS", nullable = true)
	private QCStatus technicalStatus = QCStatus.Undefined; // This will act as the default value for the column
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SOFT_SKILL_STATUS", nullable = true)
	private QCStatus softSkillStatus = QCStatus.Undefined;

	@Column(name = "UPDATE_TIME")
	private Timestamp updateTime;

	/**
	 * Need the object to send to the client, but don't need to save the whole 
	 * object into this service's database.
	 */
	@Transient
	private Trainer lastSavedBy;
	
	@Column(name = "LAST_SAVED_BY")
	private int lastSavedById;

	public Note() {
		super();
		this.updateTime = new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 
	 * @param week
	 * @param batchId
	 * @param trainee
	 * 
	 * Create individual associate notes per batch per week.
	 * 
	 */
	public Note(short week, int batchId, Trainee trainee) {
		this.week = week;
		this.batchId = batchId;
		this.trainee = trainee;
		this.traineeId = trainee.getTraineeId();
		this.type = NoteType.QC_TRAINEE;
		this.technicalStatus = QCStatus.Undefined;
		this.softSkillStatus = QCStatus.Undefined;
		this.updateTime = new Timestamp(System.currentTimeMillis());
	}
	
	/**
	 * 
	 * @param week
	 * @param batchId
	 * 
	 * Create overall batch note per week.
	 * 
	 */
	public Note(short week, int batchId) {
		this.week = week;
		this.batchId = batchId;
		this.type = NoteType.QC_BATCH;
		this.technicalStatus = QCStatus.Undefined;	// "Overall Feedback"
		this.softSkillStatus = QCStatus.Undefined;
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

	public QCStatus getTechnicalStatus() {
		return technicalStatus;
	}

	public void setTechnicalStatus(QCStatus qcStatus) {
		this.technicalStatus = qcStatus;
	}
	
	public QCStatus getSoftSkillStatus() {
		return softSkillStatus;
	}

	public void setSoftSkillStatus(QCStatus qcStatus) {
		this.softSkillStatus = qcStatus;
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

	public Trainer getLastSavedBy() {
		return lastSavedBy;
	}

	public void setUpdateTrainer(Trainer lastSavedBy) {
		this.lastSavedBy = lastSavedBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Note note = (Note) o;
		return noteId == note.noteId &&
						week == note.week &&
						batchId == note.batchId &&
						traineeId == note.traineeId &&
						lastSavedById == note.lastSavedById &&
						Objects.equals(content, note.content) &&
						Objects.equals(trainee, note.trainee) &&
						type == note.type &&
						technicalStatus == note.technicalStatus &&
						softSkillStatus == note.softSkillStatus &&
						Objects.equals(updateTime, note.updateTime) &&
						Objects.equals(lastSavedBy, note.lastSavedBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(noteId, content, week, batchId, trainee, traineeId, type, technicalStatus, softSkillStatus, updateTime, lastSavedBy, lastSavedById);
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", content=" + content + ", week=" + week + ", batchId=" + batchId
				+ ", trainee=" + trainee + ", traineeId=" + traineeId + ", type=" + type + ", technicalStatus=" + technicalStatus
				+ ", softSkillStatus=" + softSkillStatus + ", updateTime=" + updateTime + ", updateTrainer=" + lastSavedBy + "]";
	}
	
	



	
}


