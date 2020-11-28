package com.oocl.cultivation.parking_boy_parking_strategies;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parking_boy_parking_strategies.ParkingBoyParkingStrategy;

import java.util.List;

public class StandardParkingStrategy implements ParkingBoyParkingStrategy {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.park(car);
            }
            catch (NotEnoughPositionException ignored) {}
        }
        throw new NotEnoughPositionException();
    }
}
