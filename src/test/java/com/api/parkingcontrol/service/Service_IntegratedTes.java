package com.api.parkingcontrol.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repository.ParkingSpotRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingSpotService.class)
@ActiveProfiles("hml")
public class Service_IntegratedTes {
	
	@Autowired
	private ParkingSpotService service;
	
	@MockBean
	private ParkingSpotRepository repository;
	
	@Test
	public void test() {
		
		ParkingSpotModel model = new ParkingSpotModel();
		model.setParkingSpotNumber("dfsdfsdw");
		model.setLicensePlateCar("sd6dfss");
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
