package com.oocl.cultivation.parking_lot_exceptions;

public class NotEnoughPositionException extends Exception {
    public NotEnoughPositionException() {
        super("Not enough position");
    }
}
