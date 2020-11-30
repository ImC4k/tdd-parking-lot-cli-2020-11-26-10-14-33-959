package com.oocl.cultivation.parking_boy_parking_behaviors;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parkable_and_fetchables.ParkingLot;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;

import java.util.List;

public class StandardParkingBoyParkingBehavior implements ParkingBoyParkingBehavior {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        return parkingLots.stream().filter(parkingLot -> parkingLot.getAvailableSpace() > 0).findFirst().orElseThrow(NotEnoughPositionException::new).park(car);
    }
}
