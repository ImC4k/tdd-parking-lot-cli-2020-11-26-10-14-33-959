package com.oocl.cultivation.parking_boy_parking_behaviors;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parkable_and_fetchables.ParkingLot;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoyParkingBehavior implements ParkingBoyParkingBehavior {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        return parkingLots.stream().max(Comparator.comparing(this::getAvailablePositionRate)).orElseThrow(NotEnoughPositionException::new).park(car);
    }

    private double getAvailablePositionRate(ParkingLot parkingLot) {
        return (double) parkingLot.getAvailableSpace() / parkingLot.getCapacity();
    }
}
