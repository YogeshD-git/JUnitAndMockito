package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	public String getName()
	{
		return "Yogesh";
	}
	
	public String getYourName(String name)
	{
		return "Hello " + name +"!";
	}

}
