package com.api.parkingcontrol.exception;

public class ParkingSpotNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParkingSpotNotFoundException(Integer id) {
		
		super(String.format("Parking spot with id %d not found", id));
	}
}
