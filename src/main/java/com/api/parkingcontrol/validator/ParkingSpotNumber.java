package com.api.parkingcontrol.validator;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.exception.InvalidParkingSpotException;
import com.api.parkingcontrol.service.ParkingSpotService;

public class ParkingSpotNumber extends ParkingSpotValidatorHandler{

	public ParkingSpotNumber() {}

	public void validateParkingCar(ParkingSpotService service, ParkingSpotDto parkingSpotDto) {

		if (service.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
			throw new InvalidParkingSpotException("Conflict: Parking spot is already in use.");
		}
	}
}
