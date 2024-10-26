package com.java.lld.parkinglot;

import com.java.lld.parkinglot.constants.ParkingSpotType;
import com.java.lld.parkinglot.constants.VehicleType;
import com.java.lld.parkinglot.models.ParkingBill;
import com.java.lld.parkinglot.models.ParkingTicket;
import com.java.lld.parkinglot.models.Vehicle;

/**
 * @author Sharad
 *
 */
public class TestParkingLot {
	
	public static void main(String[] args) {
		
		ParkingOperationClient client = DefaultParkingOperationClient.builder()
				.build();
		
		Vehicle vehicle = Vehicle.builder()
				.licenseNumber("UP-70-1234")
				.vehicleType(VehicleType.CAR)
				.build();
		
		ParkingTicket ticket = client.generateTicket(vehicle, ParkingSpotType.MEDIUMFOURWHEEL);
		
		ParkingBill bill = client.generateBill(ticket);
		
		System.out.println("Vehicle License Number : " + bill.getParkingSpot().getVehicle().getLicenseNumber());
		System.out.println("Vehicle Type : " + bill.getParkingSpot().getVehicle().getVehicleType());
		System.out.println("Parking Spot Alloted : " + bill.getParkingSpot().getParkingSpotType());
		System.out.println("Entry Time : " + bill.getEntryTime());
		System.out.println("Entry Time : " + bill.getExitTime());
		System.out.println("Parking Spot ID : " + bill.getParkingSpot().getParkingSlotId());
	}
}