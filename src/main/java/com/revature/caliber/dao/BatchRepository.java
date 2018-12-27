package com.revature.caliber.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.BatchEntity;

@Repository(value="batchRepository")

public interface BatchRepository extends JpaRepository<BatchEntity, Integer> {

	/**
	 * A Custom query which selects the BatchEntities that start in a given year
	 * and returns them as a List.
	 * @param year Integer that represents the start year to search for.
	 * @return A List<BatchEntity> that  holds all the batches for the given
	 * start year. 
	 */
	@Query("select b from BatchEntity b where startYear(b.startDate) = :startYear AND endYear(b.endDate) = :endYear" )
	public List<BatchEntity> findAllBatchesByYear (@Param("startYear") Integer startYear, @Param("endYear") Integer endYear);
	
	/**
	 * A Custom query which selects the unique starting years for all batches. 
	 * Returns a list in ascending order.
	 * @return A List<Integer> that holds the distinct start years of all batches. The List is sorted in
	 * ascending order.
	 */
	@Query("select distinct year(b.startDate) from BatchEntity b Order By year(b.startDate) ASC ")
	public List<Integer> findBatchYears();

	

	/**
	 * A custom query which find all current batches and returns them as a List.
	 * @return A List<BatchEntity> that holds all the batches for the given current.
	 */
	@Query("select b from BatchEntity b where CURRENT_DATE BETWEEN b.startDate AND b.endDate")
	public List<BatchEntity> findAllCurrentBatches();



}
