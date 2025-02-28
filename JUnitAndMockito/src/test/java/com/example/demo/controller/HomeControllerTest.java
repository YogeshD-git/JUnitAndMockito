package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.ResponseEntity;

import com.example.demo.service.HomeService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
public class HomeControllerTest {
	private HomeController controller;
	private HomeService homeService;
	
	@BeforeEach
	void setup()
	{
		homeService = new HomeService();
		controller = new HomeController(homeService);
	}
	
	
	@Test
	@Order(1)
	@DisplayName("Test 1: Get Default Name")
	void testGetName()
	{
		String result = controller.getName();
		assertEquals("Yogesh", result,"The name should be 'Yogesh'");
	}
	
	@Test
	@Order(2)
	@DisplayName("Test 2: Get Your Name")
	void testGetYourName()
	{
		String result = controller.getYourName("Nita");
		assertEquals("Hello Nita!", result,"The response should be 'Nita Dahake'\"");
	}
	
	@Order(2)
	@DisplayName("Test 2: Get Your Name")
	@ParameterizedTest
	@ValueSource(strings = "yogesh,raju,kaju,nita")
	void testGetYourNames(String name)
	{
		String result = controller.getYourName(name);
		assertEquals("Hello "+name+"!", result,"The response should be"+name);
	}
	
	
	@Test
	@Order(3)
	@DisplayName("Test 3: Save Name")
	void testSaveName() {
		ResponseEntity<?> response = controller.saveName("Raju");
		assertEquals(201, response.getStatusCodeValue(),"Status code should be 201 Created");
		assertEquals("Raju name is saved", response.getBody(),"Response body should match");
	}
}
