package com.revature.caliber.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.caliber.beans.Trainee;

@FeignClient("user-service")
public interface TraineeClient {
	
	@GetMapping("/all/trainee")
	public List<Trainee> getAllTrainees();

}
