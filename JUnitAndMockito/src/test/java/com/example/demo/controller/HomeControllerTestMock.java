package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.service.HomeService;

public class HomeControllerTestMock {
	
	@Mock //@Mock → Creates a fake HomeService object.
	private HomeService service;
	
	@InjectMocks //Injects the mocked homeService into HomeController.
	private HomeController controller;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this); //Initializes the mocks before each test.
	}
	
	@Test
	@DisplayName("Test 1: Get Default Name")
	void testGetName() {
		when(service.getName()).thenReturn("Yogesh");
		
		String result = controller.getName();
		
		assertEquals("Yogesh", result, "The name should be 'Yogesh'");
		verify(service,times(1)).getName(); // Verify method was called once
	}

}
