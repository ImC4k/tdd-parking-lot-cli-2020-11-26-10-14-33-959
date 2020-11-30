package com.oocl.cultivation.parking_boy_fetching_behaviors;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parkable_and_fetchables.ParkingLot;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public interface ParkingBoyFetchingBehavior {
    Car fetch(ParkingTicket ticket, List<ParkingLot> parkingLots) throws UnrecognizedParkingTicketException;
}
