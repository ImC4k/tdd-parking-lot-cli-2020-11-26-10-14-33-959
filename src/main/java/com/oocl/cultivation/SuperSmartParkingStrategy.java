package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingStrategy implements ParkingBoyParkingStrategy {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMaxAvailableSpace = parkingLots.stream().max(Comparator.comparing(this::getAvailablePositionRate)).orElse(parkingLots.get(0));
        return parkingLotWithMaxAvailableSpace.park(car);
    }


    private double getAvailablePositionRate(ParkingLot parkingLot) {
        return (double) parkingLot.getAvailableSpace() / parkingLot.getCapacity();
    }
}
