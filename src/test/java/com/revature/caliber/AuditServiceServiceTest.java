/**
 * 
 */
package com.revature.caliber;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.beans.Note;
import com.revature.caliber.service.NoteService;

/**
 * NOTE!!!   This testing is based on the test data from the H2
 * 
 * @author pgerringer
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuditServiceApplication.class)
public class AuditServiceServiceTest {
	private final int BATCH_ID = 2150;
	private final short WEEK_NUMBER = 5;
	private final String MAX_VISIBILITY = "ROLE_QC";
	private final String NOTE_TYPE = "QC_TRAINEE";
	
	@Autowired
	private NoteService service;
	
	private Note note5500; //, note5501, note5502, note5540, note5457; 
	List<Note> listNote;
	
	
//	Insert into CALIBER_NOTE (NOTE_ID, NOTE_CONTENT, WEEK_NUMBER, BATCH_ID, TRAINEE_ID, MAX_VISIBILITY, NOTE_TYPE, QC_STATUS) values (1, 'Asked about Hibernate annotations. Answered: @Entity, @Id, @Column', 5, 2003, 1, 'ROLE_QC', 'QC_TRAINEE', 'Good');
//	Insert into CALIBER_NOTE (NOTE_ID, NOTE_CONTENT, WEEK_NUMBER, BATCH_ID, TRAINEE_ID, MAX_VISIBILITY, NOTE_TYPE, QC_STATUS) values (2, 'Benefits of Microservices? Answered: Eliminate single point of failure', 5, 2150, 5500, 'ROLE_QC', 'QC_TRAINEE', 'Good');
//	Insert into CALIBER_NOTE (NOTE_ID, NOTE_CONTENT, WEEK_NUMBER, BATCH_ID, TRAINEE_ID, MAX_VISIBILITY, NOTE_TYPE, QC_STATUS) values (3, 'Is JavaScript OOP? Answered: Idk. confusing...', 5, 2150, 5501, 'ROLE_QC', 'QC_TRAINEE', 'Good');
//	Insert into CALIBER_NOTE (NOTE_ID, NOTE_CONTENT, WEEK_NUMBER, BATCH_ID, TRAINEE_ID, MAX_VISIBILITY, NOTE_TYPE, QC_STATUS) values (4, 'Something smells.  I think it is the trainee', 5, 2150, 5502, 'ROLE_QC', 'QC_TRAINEE', 'Poor');
//	Insert into CALIBER_NOTE (NOTE_ID, NOTE_CONTENT, WEEK_NUMBER, BATCH_ID, TRAINEE_ID, MAX_VISIBILITY, NOTE_TYPE, QC_STATUS) values (5, 'Asked questions about collections.  Answered all with confidence.', 5, 2150, 5540, 'ROLE_QC', 'QC_TRAINEE', 'Good');
//	Insert into CALIBER_NOTE (NOTE_ID, NOTE_CONTENT, WEEK_NUMBER, BATCH_ID, TRAINEE_ID, MAX_VISIBILITY, NOTE_TYPE, QC_STATUS) values (6, 'Asked about AWS AIM.  correct', 5, 2150, 5457, 'ROLE_QC', 'QC_TRAINEE', 'Good');


	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		service = new NoteService();
		note5500 = new Note();
		
		note5500.setNoteId(2);
		note5500.setContent("Benefits of Microservices? Answered: Eliminate single point of failure");
		note5500.setWeek(WEEK_NUMBER);
		note5500.setBatchId(BATCH_ID);
		note5500.setTraineeId(5500);
//		note5500.setMaxVisibility(MAX_VISIBILITY);
		note5500.setNoteType(NOTE_TYPE);
		note5500.setQcStatus("Good");
		
		
		
		listNote.add(note5500);
		
	}
	
	@Test
	public void testFindByID() {
		Note note = service.findById(5500);
		
//		public Note findById(Integer id)
		assertEquals(note5500, note);
	}

}

