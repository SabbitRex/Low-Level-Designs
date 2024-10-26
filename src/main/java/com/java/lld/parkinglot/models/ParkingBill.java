package com.java.lld.parkinglot.models;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sharad
 *
 */
@Builder
public class ParkingBill {

	@Getter
	LocalDateTime entryTime;
	
	@Getter
	LocalDateTime exitTime;
	
	@Getter
	int billAmount;
	
	@Getter
	ParkingSpot parkingSpot;
}
