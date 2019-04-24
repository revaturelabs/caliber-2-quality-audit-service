package com.revature.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * This microservice allows us to retrieve, persist, and manipulate note information. 
 * The microservice is discoverable by Eureka and is a Spring.
 * Boot application.
 * @author 
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AuditServiceApplication {
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AuditServiceApplication.class, args);
	}
}
