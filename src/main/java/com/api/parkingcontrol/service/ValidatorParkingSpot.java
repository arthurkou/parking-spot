package com.api.parkingcontrol.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.exception.ParkingSpotNotFoundException;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.validator.ApartmentBlock;
import com.api.parkingcontrol.validator.LicensePlateCar;
import com.api.parkingcontrol.validator.ParkingSpotNumber;
import com.api.parkingcontrol.validator.ParkingSpotValidatorHandler;

@Service
public class ValidatorParkingSpot {
	
	@Autowired
	private ParkingSpotService parkingSpotService;
	
	public void validate(ParkingSpotDto parkingSpotDto) {		
		
		List<ParkingSpotValidatorHandler> validations = Arrays.asList(new ParkingSpotNumber(), 
															      	  new LicensePlateCar(), 
															          new ApartmentBlock());
		
		validations.stream().forEach(rule -> {
			rule.validateParkingCar(parkingSpotService, parkingSpotDto);
			
		});
		
	}
	
	public ParkingSpotModel isParkingSpotValid(Integer id) throws Exception {
		
		return parkingSpotService.findById(id).orElseThrow(() -> new ParkingSpotNotFoundException(id));
	}
}
