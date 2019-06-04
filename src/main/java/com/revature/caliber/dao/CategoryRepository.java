package com.revature.caliber.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query("SELECT c FROM Category c WHERE c.batchId = :batchId AND c.week = :week")
	public List<Category> findCategoryByBatchAndWeek(
			@Param("batchId") Integer batchId,
			@Param("week") Integer week);
	
	
	
}
