/*
package com.api.parkingcontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CAR_DETAIL")
public class CarDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String placaCarro;

	private boolean isRodizio;

	@OneToOne(mappedBy = "carDetail")
	private ParkingSpotModel parkingSpot;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public boolean isRodizio() {
		return isRodizio;
	}

	public void setRodizio(boolean isRodizio) {
		this.isRodizio = isRodizio;
	}

	public ParkingSpotModel getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpotModel parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

}
*/