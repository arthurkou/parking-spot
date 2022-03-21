package com.api.parkingcontrol.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //usado para testar em BD diferente de H2
@ActiveProfiles("dev")
public class Repository_Test_Postgres {
	
	@Autowired
	private ParkingSpotRepository repository;
	
	@Test
	public void naoencontrarParkingSpotByLicensePlateCar() {		
		
		assertFalse(repository.existsByLicensePlateCar("dfsdf6456"));
	}
	
	@Test
	public void encontrarParkingSpotByLicensePlateCar() {		
		
		assertTrue(repository.existsByLicensePlateCar("RRS5811"));
	}

}
