package com.api.parkingcontrol.validator;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.exception.InvalidParkingSpotException;
import com.api.parkingcontrol.service.ParkingSpotService;

public class LicensePlateCar extends ParkingSpotValidatorHandler {

	public LicensePlateCar() {}

	public void validateParkingCar(ParkingSpotService service, ParkingSpotDto parkingSpotDto) {

		if (service.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
			throw new InvalidParkingSpotException("Conflict: License Plate Car is already in use.");
		}
	}
}
