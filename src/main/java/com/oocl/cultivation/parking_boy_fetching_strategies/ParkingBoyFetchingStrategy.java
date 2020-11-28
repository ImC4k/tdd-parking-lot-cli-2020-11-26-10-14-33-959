package com.oocl.cultivation.parking_boy_fetching_strategies;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public interface ParkingBoyFetchingStrategy {
    Car fetch(ParkingTicket ticket, List<ParkingLot> parkingLots) throws UnrecognizedParkingTicketException;
}
