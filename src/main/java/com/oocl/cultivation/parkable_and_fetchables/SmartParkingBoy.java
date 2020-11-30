package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parking_boy_parking_strategies.SmartParkingStrategy;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableSpace)).orElseThrow(NotEnoughPositionException::new).park(car);
    }
}
