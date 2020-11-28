package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private ParkingBoyParkingStrategy parkingBoyParkingStrategy;
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkingBoyParkingStrategy = new StandardParkingStrategy();
    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return parkingBoyParkingStrategy.park(car, this.parkingLots);
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
