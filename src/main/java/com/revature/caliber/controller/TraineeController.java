package com.revature.caliber.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Trainee;
import com.revature.caliber.intercomm.TraineeClient;

@RestController
@RequestMapping("/trainee")
@CrossOrigin(origins = "*")
public class TraineeController {

	@Autowired
	private TraineeClient client;

	private static final Logger log = Logger.getLogger(TraineeController.class);
	
	@GetMapping("/trainees")
	public ResponseEntity<List<Trainee>> findAllByBatch(@RequestParam(defaultValue="1") Integer batch) {
		return client.findAllByBatch(batch);
	}

	@PutMapping("/update")
	public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee) {
		return client.updateTrainee(trainee);
	}

}
