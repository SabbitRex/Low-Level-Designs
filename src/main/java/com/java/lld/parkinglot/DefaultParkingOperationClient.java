package com.java.lld.parkinglot;

import java.time.LocalDateTime;

import com.java.lld.parkinglot.constants.ParkingSpotType;
import com.java.lld.parkinglot.models.ParkingBill;
import com.java.lld.parkinglot.models.ParkingSpot;
import com.java.lld.parkinglot.models.ParkingTicket;
import com.java.lld.parkinglot.models.Vehicle;

import lombok.Builder;

/**
 * @author Sharad
 *
 */
@Builder
public class DefaultParkingOperationClient implements ParkingOperationClient {

	@Override
	public ParkingTicket generateTicket(Vehicle vehicle, ParkingSpotType parkingSpotType) {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		ParkingTicket parkingTicket = ParkingTicket.builder()
				.entryTime(localDateTime)
				.parkingSpotType(parkingSpotType)
				.vehicle(vehicle)
				.build();
		
		return parkingTicket;
	}

	@Override
	public ParkingBill generateBill(ParkingTicket parkingTicket) {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		LocalDateTime entryTime = parkingTicket.getEntryTime();
		
		// Add a logic to calculate bill based on difference between entry and exit time.
		
		ParkingSpot parkingSpot = ParkingSpot.builder()
				.isParkingSlotEmpty(true)
				.parkingSlotId("0F-P12-CAR-MFW")
				.parkingSpotType(parkingTicket.getParkingSpotType())
				.vehicle(parkingTicket.getVehicle())
				.build();
		
		ParkingBill parkingBill = ParkingBill.builder()
				.parkingSpot(parkingSpot)
				.exitTime(localDateTime)
				.entryTime(entryTime)
				.billAmount(60)
				.build();
		
		return parkingBill;
	}
}