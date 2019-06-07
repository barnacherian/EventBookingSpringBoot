package com.cg.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @author :- barna 
 * SpringBootApplication class
 * */

@Configuration
@ComponentScan("com.cg.event")
@SpringBootApplication
public class EventBookingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventBookingSpringBootApplication.class, args);
		System.out.println("It works");
	}
}
