package com.api.parkingcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.exception.InvalidParkingSpotException;
import com.api.parkingcontrol.exception.ParkingSpotNotFoundException;
import com.api.parkingcontrol.model.ParkingSpotModel;

@Service
public class ValidatorParkingSpot {
	
	@Autowired
	private ParkingSpotService parkingSpotService;
	
	public void validate (ParkingSpotDto parkingSpotDto) {
		
		if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
			throw new InvalidParkingSpotException("Conflict: License Plate Car is already in use.");
		}
		
		if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
			throw new InvalidParkingSpotException("Conflict: Parking spot is already in use.");
		}
		
		if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
			throw new InvalidParkingSpotException("Conflict: Parking spot already registered for this apartment/block.");
		}
	}
	
	public ParkingSpotModel isParkingSpotValid(Integer id) throws Exception {
		
		return parkingSpotService.findById(id).orElseThrow(() -> new ParkingSpotNotFoundException(id));
	}
}
