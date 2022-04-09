package com.api.parkingcontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.service.ParkingSpotService;
import com.api.parkingcontrol.service.ValidatorParkingSpot;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	@Autowired
	private ParkingSpotService parkingSpotService;
	
	@Autowired
	private ValidatorParkingSpot validatorParkingSpot;	
	
	@GetMapping
	public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpot(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable Integer id) throws Exception {			
		return ResponseEntity.status(HttpStatus.OK).body(validatorParkingSpot.isParkingSpotValid(id));
	}

	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
		
		validatorParkingSpot.validate(parkingSpotDto);
		ParkingSpotModel parkingSpotModel = new ParkingSpotModel(parkingSpotDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable Integer id, @RequestBody ParkingSpotDto parkingSpotDto) throws Exception {

		ParkingSpotModel parkingSpotModel = validatorParkingSpot.isParkingSpotValid(id);
		parkingSpotModel = new ParkingSpotModel(parkingSpotDto, parkingSpotModel.getId());
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable Integer id) throws Exception {
		
		parkingSpotService.delete(validatorParkingSpot.isParkingSpotValid(id));
		return ResponseEntity.status(HttpStatus.OK).body("Parking spot deleted successfully.");
	}	
}
