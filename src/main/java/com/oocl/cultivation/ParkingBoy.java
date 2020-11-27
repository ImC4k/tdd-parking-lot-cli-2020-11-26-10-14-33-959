package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        return this.parkingLot.fetch(ticket);
    }
}
