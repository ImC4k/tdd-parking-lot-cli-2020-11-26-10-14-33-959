package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    protected ParkingBoyParkingStrategy parkingBoyParkingStrategy;
    protected ParkingBoyFetchingStrategy parkingBoyFetchingStrategy;
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkingBoyParkingStrategy = new StandardParkingStrategy();
        this.parkingBoyFetchingStrategy = new StandardFetchingStrategy();
    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return parkingBoyParkingStrategy.park(car, this.parkingLots);
    }

    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        return parkingBoyFetchingStrategy.fetch(ticket, this.parkingLots);
    }
}
