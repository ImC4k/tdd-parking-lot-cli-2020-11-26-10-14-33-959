package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return this.parkingLots.get(0).park(car);
    }

    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        return this.parkingLots.get(0).fetch(ticket);
    }
}
