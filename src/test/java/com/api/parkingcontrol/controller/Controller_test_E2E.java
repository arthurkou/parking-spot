/*
package com.api.parkingcontrol.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingSpotController.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Controller_test_E2E {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void saveParkingSpot_test () throws Exception {
		
		URI uri = new URI("/parking-spot");
		String json = "{\r\n"
				+ "    \"parkingSpotNumber\": \"1089\",\r\n"
				+ "    \"licensePlateCar\": \"RRS5819\",\r\n"
				+ "    \"brandCar\": \"audi\",\r\n"
				+ "    \"modelCar\": \"q5\",\r\n"
				+ "    \"colorCar\": \"black\",\r\n"
				+ "    \"responsibleName\": \"Carlos Daniel\",\r\n"
				+ "    \"apartment\": \"207\",\r\n"
				+ "    \"block\": \"F\"\r\n"
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
*/