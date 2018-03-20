package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoLogsApplication {
	private static final Logger logger = LogManager.getLogger(DemoLogsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoLogsApplication.class, args);
		writeLogs();
	}
	public static void writeLogs() {
		System.out.println("First Success");
		 	logger.debug("Debugging log");
	        logger.info("Info log");
	        logger.warn("Hey, This is a warning!");
	        logger.error("Oops! We have an Error. OK");
	        logger.fatal("Damn! Fatal error. Please fix me.");
	}
}
