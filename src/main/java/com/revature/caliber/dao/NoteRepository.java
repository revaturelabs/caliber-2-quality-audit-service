
package com.revature.caliber.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Note;
import com.revature.caliber.beans.NoteType;

/**
 * Handles retrieving notes from a database
 * 
 * @author
 *
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

	/**
	 * Updating content, week columns of note table.
	 * 
	 * @param content
	 * @param weekNumber
	 * @param noteId
	 * @return 1 if success
	 */
	@Modifying
	@Query("UPDATE Note n SET n.content = :noteContent, n.week = :weekNumber where n.noteId = :noteId")
	//Changing types to primitives instead of wrapper classes
	int updateWeekForNote(@Param("noteContent") String content, @Param("weekNumber") short weekNumber,
			@Param("noteId") int noteId);

	/**
	 * 
	 * @param batchId
	 * @param week
	 * @return
	 */
	@Query("SELECT n FROM Note n WHERE n.batchId = :batchId")//AND n.type = :type")
	//What do we need displayed? The actual notes, year, quarter, batch
	//trainee, technical skills, soft skills
	//Overall qc status
	//overall qc notes
	//Changing types to primitives instead of wrapper classes
    public List<Note> findQCNotesByBatch(
            @Param("batchId") int batchId);
            //@Param("type") NoteType type);

	
	@Query("SELECT n FROM Note n WHERE n.batchId = :batchId AND n.week = :week AND n.type = :type")
	//Changing types to primitives instead of wrapper classes
	public List<Note> findQCNotesByBatchAndWeek(
			@Param("batchId") int batchId,
			@Param("week") short week,
			@Param("type") NoteType type);
	
	//Changing types to primitives instead of wrapper classes
	@Query("SELECT n FROM Note n WHERE n.batchId = :batchId AND n.week = :week AND n.type = :type")
	public Note findQCBatchNotes(@Param("batchId") int batchId, @Param("week") short week,
			@Param("type") NoteType type);
	
	//Changing types to primitives instead of wrapper classes
	@Query("SELECT n FROM Note n WHERE n.traineeId = :traineeId")
	public List<Note> findByTraineeId(@Param("traineeId") int traineeId, Sort sort);

	//Changing types to primitives instead of wrapper classes
	public List<Note> findNotesByBatchIdAndType(int batchId, NoteType type);
}
