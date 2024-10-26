package com.java.lld.parkinglot.models;

import com.java.lld.parkinglot.constants.VehicleType;

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
