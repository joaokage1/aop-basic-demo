package com.example.aopdemo;

import com.example.aopdemo.business.BusinessService1;
import com.example.aopdemo.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BusinessService1 businessService1;

	@Autowired
	private BusinessService2 businessService2;

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Max value is {}", businessService1.calculateMax());
		logger.info("Min value is {}", businessService2.calculateMin());
	}
}
