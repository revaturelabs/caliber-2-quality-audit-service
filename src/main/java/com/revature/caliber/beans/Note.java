package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CALIBER_NOTE")
public class Note implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5641156519488500295L;

	@Id
	@Column(name = "NOTE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_ID_SEQUENCE")
	@SequenceGenerator(name = "NOTE_ID_SEQUENCE", sequenceName = "NOTE_ID_SEQUENCE")
	private int noteId;
	
	

}
