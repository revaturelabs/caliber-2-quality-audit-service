package com.revature.caliber.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.caliber.beans.Trainer;

/**
 * To intercomm with user-service to get trainer data.
 * @author thienle
 *
 */
@FeignClient(name= "user-service", url = "localhost:9085/")
public interface TrainerClient {

	@GetMapping("/all/trainer/all")
	public ResponseEntity<List<Trainer>> getAllTrainers();
}
