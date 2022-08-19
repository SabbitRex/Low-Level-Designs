package com.sabbitrex.lowleveldesigns.parkinglot.models;

import com.sabbitrex.lowleveldesigns.parkinglot.constants.VehicleType;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Sharad
 *
 */
@Builder
public class Vehicle {
	
	@Getter
	private String licenseNumber;
	
	@Getter
	private VehicleType vehicleType;
}
