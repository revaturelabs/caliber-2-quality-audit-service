package com.revature.caliber.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.service.BatchService;

@RestController
@CrossOrigin(origins="*")
public class BatchController {
	
	private static final Logger log = Logger.getLogger(BatchController.class);
	
	@Autowired
	private BatchService service;
	
	@GetMapping("/batches")
	public List<Batch> getAllBatches() {
		
		log.trace("in batches: Looking for batch");
		return service.getAllBatches();
	}
	
	/*
	@GetMapping("/batches")
	public List<Batch> getBatchesByYear(int startYear, int endYear) {
		
		log.trace("in batches: Looking for batch");
		return service.getAllBatches();
	}
	*/
	
	@GetMapping(value="/batch/{id}") 
	public Batch getBatch(@PathVariable Integer id) {
		log.trace("IN FIND ONE BATCH");
		return service.findById(id);
	}

}
