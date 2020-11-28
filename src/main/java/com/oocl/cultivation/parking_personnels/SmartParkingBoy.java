package com.oocl.cultivation.parking_personnels;

import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.parking_boy_parking_strategies.SmartParkingStrategy;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        super.parkingBoyParkingStrategy = new SmartParkingStrategy();
    }
}
