package com.java.lld.parkinglot;

import com.java.lld.parkinglot.constants.ParkingSpotType;
import com.java.lld.parkinglot.models.ParkingBill;
import com.java.lld.parkinglot.models.ParkingTicket;
import com.java.lld.parkinglot.models.Vehicle;

/**
 * @author Sharad
 *
 */
public interface ParkingOperationClient {
	
	ParkingTicket generateTicket(Vehicle vehicle, ParkingSpotType parkingSpotType);
	
	ParkingBill generateBill(ParkingTicket parkingTicket);
}
