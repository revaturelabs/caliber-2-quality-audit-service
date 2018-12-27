package com.revature.caliber.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.caliber.beans.Trainee;

@FeignClient("user-service")
public interface TraineeClient {
	
	/**
	 * retrieve all trainees from user-service
	 * @return
	 */
	@GetMapping("/trainees") 
	public List<Trainee> findAllTrainees();
	
	@GetMapping("/trainee/{id}")
	public Trainee findTraineeById(@PathVariable("id") int id);
	
	@PostMapping("/all/trainee/create")
	public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee);
	
}
