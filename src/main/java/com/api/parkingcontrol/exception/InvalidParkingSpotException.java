package com.api.parkingcontrol.exception;

public class InvalidParkingSpotException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidParkingSpotException(String string) {
		
		super(String.format(string));
		
	}

}
