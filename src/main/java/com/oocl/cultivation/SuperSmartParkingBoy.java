package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMaxAvailableSpace = this.parkingLots.stream().max(Comparator.comparing(parkingLot -> (double) parkingLot.getAvailableSpace() / parkingLot.getCapacity())).orElse(this.parkingLots.get(0));
        return parkingLotWithMaxAvailableSpace.park(car);
    }
}