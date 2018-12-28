package com.revature.caliber.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.BatchEntity;
import com.revature.caliber.service.BatchService;

@RestController()
@CrossOrigin("*")
public class BatchController {
	private Logger log = Logger.getLogger("BatchController");
	

	@Autowired
	private BatchService bs;
	
	/**
	 * Accepts a HTTP GET request. 
	 * Returns a List of all BatchEntities on the connected database as a JSON object.
	 * @return a List<BatchEntity> that contains all BatchEntities in the database.
	 */
	@GetMapping({ "/qc/batch/all", "/vp/batch/all" })
	public List<BatchEntity> getAllBatches() {
		log.debug("Inside getAllBatches");
		return bs.findAllBatches();
	}
	
	/**
	 * Accepts a HTTP GET request. Mapped to ProjectURL/id/{pathVariable}
	 * Returns a BatchEntity as a JSON entity based on the given id.
	 * @param id An Integer that contains the BatchEntity id. The id is passed as a path variable. 
	 * @return a BatchEntity which has the same id as the given id. Null if no matching 
	 * 			id was found. Value is returned as a JSON object.
	 */
	@GetMapping("all/batch/{id}")
	public BatchEntity getBatchById(@PathVariable("id") Integer id) {
		log.debug("Inside findBatchById");
		return bs.findBatchById(id);
	}
	
	/**
	 * Accepts a HTTP Get Request. Mapped to ProjectURL/year/{path variable}
	 * Returns a List<BatchEntity> which contains Batches in the given year.
	 * The List is returned as a JSON Object.
	 * @param year An Integer representing the year. Year is taken in as a path variable.
	 * @return A List<BatchEntity> of batches in the given year. Returned as a JSON object
	 */
	@GetMapping({"/qc/batch/{startYear}","/qc/batch/{endYear}",
		"/vp/batch/{startYear}","/vp/batch/{endYear}"})
	public List<BatchEntity> getBatchesByYear(@PathVariable("startYear") Integer startYear
			, @PathVariable("endYear") Integer endYear) {
		log.debug("Inside getBatchesByYear");
		return bs.findBatchesByYear(startYear, endYear);
	}
	/**
	 * Accepts a HTTP Get Request. Mapped to ProjectURL/vp/batch/all/current
	 * Returns a List<BatchEntity> which contains current batches; which means the current date is 
	 * between their start date and end date.
	 * The List is returned as a JSON object.
	 * @return A List<BatchEntity> of current batches.
	 */
	@GetMapping("/vp/batch/all/current")
	public List<BatchEntity> getAllCurrentBatches(){
		log.debug("Inside getAllCurrentBatches");
		return bs.findCurrentBatches();
	}
	
	
	/**
	 *  Accepts a HTTP POST request.
	 *  Attempts to add a BatchEntity to the database. 
	 *  @param be The BatchEntity to add to the database.
	 * 
	 */
	@PostMapping("/all/batch/create")
	public void createBatch(@RequestBody BatchEntity be) {
		log.debug("Inside createBatch");
		try {
			bs.createBatch(be);
		} catch (IllegalArgumentException e) {
			log.warn(e.getMessage() + "Inside BatchController.createBatch(BatchEntity) ");
		}
	}
	
	/**
	 * Accepts a HTTP PUT request.
	 * Takes in a BatchEntity and updates any matching BatchEntity in the database. If
	 * no BatchEntity on the database has a matching id, then the given BatchEntity is
	 * added to the database.
	 * 
	 * @param be The BatchEntity to update.
	 */
	@PutMapping("/all/batch/update")
	public void updateBatch(@RequestBody BatchEntity be) {
		log.debug("Inside updateBatch");
		bs.updateBatch(be);
	}
	
	/**
	 * Accepts a HTTP DELETE request.
	 * Takes in a BatchEntity and attempts to delete it from the database. 
	 * If the give BatchEntity does not exist in the database, the database will not be changed.
	 * @param be The BatchEntity to delete from the database.
	 */
	@DeleteMapping("/all/batch/delete/{batchId}")
	public void deleteBatch(@PathVariable String batchId) {
		log.debug("Inside deleteBatch");
		bs.deleteBatch(Integer.parseInt(batchId));
	}
	
	/**
	 * Accepts a HTTP GET Request 
	 * This method finds all batch start years and returns a List<Integer>.
	 * List is in ascending order and holds only distinct years.
	 * @return A List<Integer> filled with batch start years 
	 */
	@GetMapping("/all/batch/valid_years")
	public List<Integer> batchYears(){
		return bs.findBatchYears();
		
	}

	


}
