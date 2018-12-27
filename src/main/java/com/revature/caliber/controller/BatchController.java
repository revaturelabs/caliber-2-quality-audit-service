package com.revature.caliber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.intercomm.BatchClient;
import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.BatchEntity;

@RestController
@CrossOrigin("*")
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	BatchClient client;
	
	@GetMapping("/batches")
	public List<BatchEntity> getAllBatches() {
		return client.getAllBatches();
	}
	
	@GetMapping("/batch/{id}")
	public BatchEntity getBatchById(@PathVariable Integer id) {
		return client.getBatchById(id);
	}
	
	@GetMapping("/valid-year")
	public List<Integer> batchYears() {
		return client.batchYears();
	}

}
