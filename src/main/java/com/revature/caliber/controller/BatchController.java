package com.revature.caliber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.BatchEntity;
import com.revature.caliber.intercomm.BatchClient;

@RestController
@CrossOrigin("*")
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	BatchClient client;
	
	@GetMapping("/batches")
	public List<BatchEntity> getAllBatches(@RequestParam(required=false) Integer year, @RequestParam(required=false) Integer quarter) {
		return client.getAllBatches(year, quarter);
	}
	
	@GetMapping("/batch/{id}")
	public BatchEntity getBatchById(@PathVariable Integer id) {
		System.out.println("***************** " + id + " *****************");
		return client.getBatchById(id);
	}
	
	@GetMapping("/{startYear}")
	public List<BatchEntity> getBatchesByYear(@PathVariable Integer startYear) {
		return client.getBatchesByYear(startYear);
	}
	
	@GetMapping("/{startYear}/{quarter}") List<BatchEntity> getBatchesByYearByQuarter(@PathVariable Integer startYear, @PathVariable Integer quarter){
		return client.getBatchesByYearByQuarter(startYear, quarter);
	}
	
	@GetMapping("/valid-years")
	public List<Integer> batchYears() {
		return client.batchYears();
	}

}
