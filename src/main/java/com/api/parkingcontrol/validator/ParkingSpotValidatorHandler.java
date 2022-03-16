package com.api.parkingcontrol.validator;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.service.ParkingSpotService;

public abstract class ParkingSpotValidatorHandler {
	
	public abstract void validateParkingCar(ParkingSpotService service, ParkingSpotDto parkingSpotDto);
}
