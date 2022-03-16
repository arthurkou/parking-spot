package com.api.parkingcontrol.validator;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.exception.InvalidParkingSpotException;
import com.api.parkingcontrol.service.ParkingSpotService;

public class ApartmentBlock extends ParkingSpotValidatorHandler{
	
	public ApartmentBlock() {}

	public void validateParkingCar(ParkingSpotService service, ParkingSpotDto parkingSpotDto) {

		if (service.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
			throw new InvalidParkingSpotException("Conflict: Parking spot already registered for this apartment/block.");
		}
	}
}
