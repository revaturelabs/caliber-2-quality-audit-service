package com.revature.caliber.beans;

import java.io.Serializable;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 *
 */
@Entity
@Table(name = "CALIBER_NOTE")
//@Cacheable
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
	 * Will be null if the note is individual trainee feedback
	 */
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_ID", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Batch batch;

	/**
	 * Will be null if the note is overall batch feedback
	 */
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINEE_ID", nullable = true)
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Trainee trainee;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "MAX_VISIBILITY")
	private TrainerRole maxVisibility;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "NOTE_TYPE")
	private NoteType type;

	@Column(name = "IS_QC_FEEDBACK", nullable = false)
	private boolean qcFeedback;

	@Enumerated(EnumType.STRING)
	@Column(name = "QC_STATUS", nullable = true)
	private QCStatus qcStatus;

	public Note() {
		super();
		this.maxVisibility = TrainerRole.ROLE_TRAINER;
	}

	public Note(int noteId, String content, short week, Batch batch, Trainee trainee, TrainerRole maxVisibility,
			NoteType type, boolean qcFeedback, QCStatus qcStatus) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.week = week;
		this.batch = batch;
		this.trainee = trainee;
		this.maxVisibility = maxVisibility;
		this.type = type;
		this.qcFeedback = qcFeedback;
		this.qcStatus = qcStatus;
	}
	
	
}

