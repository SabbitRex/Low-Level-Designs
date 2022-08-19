package com.sabbitrex.lowleveldesigns.parkinglot;

import com.sabbitrex.lowleveldesigns.parkinglot.constants.ParkingSpotType;
import com.sabbitrex.lowleveldesigns.parkinglot.models.ParkingBill;
import com.sabbitrex.lowleveldesigns.parkinglot.models.ParkingTicket;
import com.sabbitrex.lowleveldesigns.parkinglot.models.Vehicle;

/**
 * @author Sharad
 *
 */
public interface ParkingOperationClient {
	
	ParkingTicket generateTicket(Vehicle vehicle, ParkingSpotType parkingSpotType);
	
	ParkingBill generateBill(ParkingTicket parkingTicket);
}
