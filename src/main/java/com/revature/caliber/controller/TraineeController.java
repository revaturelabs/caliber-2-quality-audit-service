package com.revature.caliber.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Trainee;
import com.revature.caliber.intercomm.TraineeClient;

@RestController
@RequestMapping("/trainee")
@CrossOrigin(origins="*")
public class TraineeController {
	
	@Autowired
	private TraineeClient client;
	
	private static final Logger log = Logger.getLogger(TraineeController.class);
	
	/**
	 * Retrieve all trainees from user-service
	 * @return
	 */
	@GetMapping("/trainees")
	public List<Trainee> findAllTrainees() {
		return client.findAllTrainees();
	}
	
//	@GetMapping("/trainees")
//	public ResponseEntity<List<Trainee>> findAllByBatch(Integer batch) {
//		return client.findAllByBatch(batch);
//	}
	
	
	@GetMapping("/trainee/{id}")
	public Trainee findTraineeById(@PathVariable int id) {
		return client.findTraineeById(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
		return client.createTrainee(trainee);
	}
	
}
