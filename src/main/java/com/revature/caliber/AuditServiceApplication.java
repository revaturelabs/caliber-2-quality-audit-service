package com.revature.caliber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.revature.caliber.beans.Note;
import com.revature.caliber.dao.AuditRepository;


import com.revature.caliber.beans.Note;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AuditServiceApplication implements CommandLineRunner {
	
	@Autowired
	private AuditRepository repo;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AuditServiceApplication.class, args);
	}

	/**
	 * Dummy data
	 */
	@Override
	public void run(String... args) throws Exception {
		
//		repo.save(new Note(1, "Good job"));
//		repo.save(new Note(2, "Yellow"));
		
	}


}
