package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMaxAvailableSpace = this.parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableSpace)).orElse(this.parkingLots.get(0));
        return parkingLotWithMaxAvailableSpace.park(car);
    }
}
