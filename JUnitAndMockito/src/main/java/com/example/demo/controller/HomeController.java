package com.example.demo.controller;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	public final HomeService service;
	
	@Autowired
	public HomeController(HomeService service) {
		this.service = service;
	}
	
	@GetMapping("/name")
	public String getName()
	{
		return service.getName();
	}
	
	@GetMapping("/name/{enteredname}")
	public String getYourName(@PathVariable String enteredname)
	{
		return service.getYourName(enteredname);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveName(@RequestBody String name)
	{
		return new ResponseEntity<>(name+" name is saved",HttpStatus.CREATED);
	}
	
	
	

}
