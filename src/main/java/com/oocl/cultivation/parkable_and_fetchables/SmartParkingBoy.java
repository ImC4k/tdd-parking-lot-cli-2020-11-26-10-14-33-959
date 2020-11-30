package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.parking_boy_parking_behaviors.SmartParkingBoyParkingStrategy;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        super.parkingBoyParkingBehavior = new SmartParkingBoyParkingStrategy();
    }
}
