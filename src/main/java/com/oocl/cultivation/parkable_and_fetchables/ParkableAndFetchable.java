package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

public interface ParkableAndFetchable {
    ParkingTicket park(Car car) throws NotEnoughPositionException;
    Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException;
}
