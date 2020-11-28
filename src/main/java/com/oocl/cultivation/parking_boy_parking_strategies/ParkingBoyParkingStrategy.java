package com.oocl.cultivation.parking_boy_parking_strategies;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.NotEnoughPositionException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public interface ParkingBoyParkingStrategy {
    ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException;
}
