package com.oocl.cultivation;

import com.oocl.cultivation.parking_boy_fetching_strategies.ParkingBoyFetchingStrategy;
import com.oocl.cultivation.parking_boy_fetching_strategies.StandardFetchingStrategy;
import com.oocl.cultivation.parking_boy_parking_strategies.ParkingBoyParkingStrategy;
import com.oocl.cultivation.parking_boy_parking_strategies.StandardParkingStrategy;

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
