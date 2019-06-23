package com.revature.caliber.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.BatchEntity;

@FeignClient("batch-service")
public interface BatchClient {
	
	@GetMapping("/batch/vp/batch/all")
	public List<BatchEntity> getAllBatches(@RequestParam(name="year", required=false) Integer year, @RequestParam(name="quarter", required=false) Integer quarter);

	
	@GetMapping("/batch/all/batch/{id}")
	public BatchEntity getBatchById(@PathVariable("id") Integer id);
	
	@GetMapping("/batch/vp/batch/{startYear}")
	public List<BatchEntity> getBatchesByYear(@PathVariable("startYear") Integer startYear);
										
	@GetMapping("/batch/vp/batch/{startYear}/{quarter}")
	public List<BatchEntity> getBatchesByYearByQuarter(@PathVariable("startYear") Integer startYear, @PathVariable("quarter") Integer quarter);
	
	@GetMapping("/batch/all/batch/valid_years")
	public List<Integer> batchYears();
}
