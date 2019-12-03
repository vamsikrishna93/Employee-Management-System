package com.ismav.ems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EmployeeManagementSystemApplication {

	private static Logger logger = LogManager.getLogger(EmployeeManagementSystemApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementSystemApplication.class, args);

		logger.info("***************************************************");
		logger.info("*               Application Started               *");
		logger.info("***************************************************");
	}

}
