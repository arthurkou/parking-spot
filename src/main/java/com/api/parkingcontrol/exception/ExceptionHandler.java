package com.api.parkingcontrol.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ParkingSpotNotFoundException.class)
    public ResponseEntity<Object> parkingSpotNotFoundException(Exception ex) {
 
 
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
 
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidParkingSpotException.class)
	public ResponseEntity<Object> invalidParkingSpotException(Exception ex) {
		
		Map<String,Object> response = new LinkedHashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
 
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);		
	}
}
