package com.oocl.cultivation.parking_lot_exceptions;

public class UnrecognizedParkingTicketException extends Exception{
    public UnrecognizedParkingTicketException() {
        super("Unrecognized parking ticket");
    }
}
