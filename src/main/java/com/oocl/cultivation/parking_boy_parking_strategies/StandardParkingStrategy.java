package com.oocl.cultivation.parking_boy_parking_strategies;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public class StandardParkingStrategy implements ParkingBoyParkingStrategy {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        return parkingLots.stream().filter(parkingLot -> parkingLot.getAvailableSpace() > 0).findFirst().orElseThrow(NotEnoughPositionException::new).park(car);
    }
}
