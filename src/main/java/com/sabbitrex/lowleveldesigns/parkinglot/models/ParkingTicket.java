package com.sabbitrex.lowleveldesigns.parkinglot.models;

import java.time.LocalDateTime;

import com.sabbitrex.lowleveldesigns.parkinglot.constants.ParkingSpotType;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sharad
 *
 */
@Builder
public class ParkingTicket {

	@Getter
	private LocalDateTime entryTime;

	@Getter
	private ParkingSpotType parkingSpotType;

	@Getter
	private Vehicle vehicle;
}
