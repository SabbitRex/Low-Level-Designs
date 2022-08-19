package com.sabbitrex.lowleveldesigns.parkinglot;

import com.sabbitrex.lowleveldesigns.parkinglot.constants.ParkingSpotType;
import com.sabbitrex.lowleveldesigns.parkinglot.constants.VehicleType;
import com.sabbitrex.lowleveldesigns.parkinglot.models.ParkingBill;
import com.sabbitrex.lowleveldesigns.parkinglot.models.ParkingTicket;
import com.sabbitrex.lowleveldesigns.parkinglot.models.Vehicle;

/**
 * @author Sharad
 *
 */
public class Test {
	
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