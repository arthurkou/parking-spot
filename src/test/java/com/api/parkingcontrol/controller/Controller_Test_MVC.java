package com.api.parkingcontrol.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.api.parkingcontrol.service.ParkingSpotService;
import com.api.parkingcontrol.service.ValidatorParkingSpot;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ParkingSpotController.class)
@ActiveProfiles("hml")
public class Controller_Test_MVC {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ParkingSpotService service;
	
	@MockBean
	private ValidatorParkingSpot validator;
	
	@Test
	public void saveParkingSpot_test () throws Exception {
		
		URI uri = new URI("/parking-spot");
				
		String json = "{\r\n"
				+ "    \"parkingSpotNumber\": \"1087\",\r\n"
				+ "    \"licensePlateCar\": \"RRS5817\",\r\n"
				+ "    \"brandCar\": \"audi\",\r\n"
				+ "    \"modelCar\": \"q5\",\r\n"
				+ "    \"colorCar\": \"black\",\r\n"
				+ "    \"responsibleName\": \"Carlos Daniel\",\r\n"
				+ "    \"apartment\": \"206\",\r\n"
				+ "    \"block\": \"S\"\r\n"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(MockMvcResultMatchers
				.status()
				.isCreated());
				//.is(201));
		
	}
}
