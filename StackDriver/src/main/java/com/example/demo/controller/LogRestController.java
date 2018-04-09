package com.example.demo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.json.Json;
import com.google.gson.JsonObject;

@RestController
public class LogRestController {
	private static int red=0;
	private static final Logger logger = Logger.getLogger(LogRestController.class.getName());
	@GetMapping("/hello")
	public ResponseEntity<Object> logCheck(){

		RestTemplate rest = new RestTemplate();
		for(int i=0; i<2;i++) { 	
		logger.log(Level.SEVERE," ERROR with java.util.logging");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@GetMapping("/counter")
	public ResponseEntity<Object> redCounter(){
		red++;
		logger.log(Level.SEVERE," ERROR");
		
		JsonObject json = new JsonObject();
		return new ResponseEntity<Object>(red, HttpStatus.OK);
		
	}
	@GetMapping("/error")
	public ResponseEntity<Object> err(){

		logger.log(Level.SEVERE," ERROR", new IllegalArgumentException());

		return new ResponseEntity<Object>( HttpStatus.OK);
		
	}
}
