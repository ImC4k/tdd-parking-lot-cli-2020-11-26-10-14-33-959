package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.*;
import com.oocl.cultivation.parking_boy_fetching_behaviors.ParkingBoyFetchingBehavior;
import com.oocl.cultivation.parking_boy_fetching_behaviors.StandardParkingBoyFetchingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.ParkingBoyParkingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.StandardParkingBoyParkingBehavior;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public class ParkingBoy implements ParkableAndFetchable {
    private final List<ParkingLot> parkingLots;
    protected ParkingBoyParkingBehavior parkingBoyParkingBehavior;
    protected ParkingBoyFetchingBehavior parkingBoyFetchingBehavior;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkingBoyParkingBehavior = new StandardParkingBoyParkingBehavior();
        this.parkingBoyFetchingBehavior = new StandardParkingBoyFetchingBehavior();
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return this.parkingBoyParkingBehavior.park(car, parkingLots);
    }

    @Override
    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        return this.parkingBoyFetchingBehavior.fetch(ticket, parkingLots);
    }
}
