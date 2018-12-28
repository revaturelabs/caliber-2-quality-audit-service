package com.revature.caliber.intercomm;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.caliber.beans.Trainee;

@FeignClient(name= "user-service", url = "http://caliber-v2-1680103809.eu-west-2.elb.amazonaws.com/user")
public interface TraineeClient {
	
	
	
	@GetMapping("/trainee/{id}")
	public Trainee findTraineeById(@PathVariable("id") int id);
	
	
	@GetMapping(value="/all/trainee", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> findAllByBatch(@RequestParam("batch") Integer batch);
	
	@PutMapping("all/trainee/update")
	public ResponseEntity<Trainee> updateTrainee(@Valid @RequestBody Trainee trainee);
	
}
