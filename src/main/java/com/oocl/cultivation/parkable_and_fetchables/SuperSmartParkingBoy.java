package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.parking_boy_parking_behaviors.SuperSmartParkingBoyParkingBehavior;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingBoyParkingBehavior = new SuperSmartParkingBoyParkingBehavior();
    }
}
