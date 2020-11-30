package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return parkingLots.stream().max(Comparator.comparing(this::getAvailablePositionRate)).orElseThrow(NotEnoughPositionException::new).park(car);
    }


    private double getAvailablePositionRate(ParkingLot parkingLot) {
        return (double) parkingLot.getAvailableSpace() / parkingLot.getCapacity();
    }
}
