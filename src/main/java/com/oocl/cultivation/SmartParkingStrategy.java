package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingStrategy implements ParkingBoyParkingStrategy{
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMaxAvailableSpace = parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableSpace)).orElse(parkingLots.get(0));
        return parkingLotWithMaxAvailableSpace.park(car);
    }
}
