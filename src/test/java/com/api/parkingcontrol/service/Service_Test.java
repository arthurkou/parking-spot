package com.api.parkingcontrol.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repository.ParkingSpotRepository;

public class Service_Test {
	
	@InjectMocks
	private ParkingSpotService ser;
	
	@Mock
	private ParkingSpotRepository repository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void encontrarParkingSpotById() {		
		
		ParkingSpotModel model;
		model = new ParkingSpotModel();
		when(ser.save(model)).thenReturn(model);
	}

}
