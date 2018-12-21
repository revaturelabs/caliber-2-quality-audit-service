package com.revature.caliber.beans;

import java.io.Serializable;

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
 * @author thienle
 *
 */
@Entity
@Table(name = "CALIBER_NOTE")
public class Note implements Serializable{

	private static final long serialVersionUID = -4960654794116385953L;

	@Id
	@Column(name = "NOTE_ID")
	@SequenceGenerator(name = "NOTE_SEQ_GEN", sequenceName = "NOTE_SEQUENCE")
	@GeneratedValue(generator = "NOTE_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int noteId;

	@Length(min=0, max=4000)
	@Column(name = "NOTE_CONTENT")
	private String content;

//	@Min(value=1)
//	@Column(name = "WEEK_NUMBER")
//	private short week;


//	@Enumerated(EnumType.ORDINAL)
//	@Column(name = "MAX_VISIBILITY")
//	private TrainerRole maxVisibility;
//
//	@NotNull
//	@Enumerated(EnumType.STRING)
//	@Column(name = "NOTE_TYPE")
//	private NoteType type;

//	@Column(name = "IS_QC_FEEDBACK", nullable = false)
//	private boolean qcFeedback;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "QC_STATUS", nullable = true)
//	private QCStatus qcStatus;

	public Note() {
	}

public Note(int noteId, String content) {
	super();
	this.noteId = noteId;
	this.content = content;
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

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "Note [noteId=" + noteId + ", content=" + content + "]";
}
	
	
	

}
