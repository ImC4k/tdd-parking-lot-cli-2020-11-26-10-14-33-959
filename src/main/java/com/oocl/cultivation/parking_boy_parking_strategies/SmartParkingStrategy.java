package com.oocl.cultivation.parking_boy_parking_strategies;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parking_boy_parking_strategies.ParkingBoyParkingStrategy;

import java.util.Comparator;
import java.util.List;

public class SmartParkingStrategy implements ParkingBoyParkingStrategy {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMaxAvailableSpace = parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableSpace)).orElse(parkingLots.get(0));
        return parkingLotWithMaxAvailableSpace.park(car);
    }
}
