package com.api.parkingcontrol.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.parkingcontrol.model.ParkingSpotModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service_IntegratedTes {
	
	@Autowired
	private ParkingSpotService service;
	
	@Test
	public void test() {
		
		ParkingSpotModel model = new ParkingSpotModel();
		model.setParkingSpotNumber("dfsdfsdf");
		model.setLicensePlateCar("sd6dfsd");
		model.setBrandCar("dadadad");
		model.setModelCar("df");
		model.setColorCar("asdasdas");
		model.setApartment("11");
		model.setBlock("S");
		model.setResponsibleName("gfds");
		model.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		
		assertNotNull(service.save(model));
		
	}
 
}
