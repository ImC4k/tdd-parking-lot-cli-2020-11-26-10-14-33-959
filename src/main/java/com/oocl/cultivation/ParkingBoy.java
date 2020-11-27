package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.park(car);
            }
            catch (NotEnoughPositionException ignored) {}
        }
        throw new NotEnoughPositionException();
    }

    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetch(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {}
        }
        throw new UnrecognizedParkingTicketException();
    }
}
