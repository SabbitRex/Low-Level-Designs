package com.java.lld.parkinglot.models;

import com.java.lld.parkinglot.constants.ParkingSpotType;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sharad
 *
 */
@Builder
public class ParkingSpot {

	@Getter
	private String parkingSlotId;
	
	@Getter
	private boolean isParkingSlotEmpty;

	@Getter
	private ParkingSpotType parkingSpotType;

	@Getter
	private Vehicle vehicle;
}
