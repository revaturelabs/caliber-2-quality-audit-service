package com.revature.caliber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Note;

/**
 * Handles retrieving notes from a database
 * @author thienle
 *
 */
@Repository
public interface NoteRepository extends JpaRepository <Note, Integer> {
	
//	@Modifying
//	@Query("UPDATE NOTE n SET n.WEEK = :weekNumber where n.noteId = :noteId")
//	int updateWeekForNote(@Param("weekNumber") short weekNumber, @Param("noteId") int noteId);
	

}
