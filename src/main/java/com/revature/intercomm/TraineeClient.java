package com.revature.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.caliber.beans.Book;
import com.revature.caliber.beans.Trainee;


@FeignClient("user_service")
public interface TraineeClient {

	@GetMapping("/all/trainee")
	public List<Trainee> getAllTrainees();
}
