package com.revature.caliber.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.BatchEntity;

@FeignClient("batch-service")
public interface BatchClient {
	
	@GetMapping("/qc/batch/all")
	//@GetMapping({ "/qc/batch/all", "/vp/batch/all" })
	public List<Batch> getAllBatches();

	
	@GetMapping("/all/batch/{id}")
	public Batch getBatchById(@PathVariable("id") Integer id);
	
	
	@GetMapping("all/batch/valid_years")
	public List<Integer> batchYears();
}
