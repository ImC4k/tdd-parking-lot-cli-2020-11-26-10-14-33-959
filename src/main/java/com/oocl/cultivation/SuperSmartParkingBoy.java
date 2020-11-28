package com.oocl.cultivation;

import com.oocl.cultivation.parking_boy_parking_strategies.SuperSmartParkingStrategy;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        super.parkingBoyParkingStrategy = new SuperSmartParkingStrategy();
    }
}
