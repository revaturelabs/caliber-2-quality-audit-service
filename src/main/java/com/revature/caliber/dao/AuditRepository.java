package com.revature.caliber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.caliber.beans.Note;

/**
 * Handles retrieving notes from a database
 * @author thienle
 *
 */
@Repository
public interface AuditRepository extends JpaRepository <Note, Integer> {

}
