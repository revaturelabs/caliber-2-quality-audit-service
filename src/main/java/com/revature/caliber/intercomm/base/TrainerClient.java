package com.revature.caliber.intercomm.base;

import com.revature.caliber.beans.Trainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * To intercomm with user-service to get trainer data.
 * @author thienle
 *
 */
public interface TrainerClient {

	@GetMapping("/user/trainers")
	public ResponseEntity<List<Trainer>> getAllTrainers();
}
