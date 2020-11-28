package com.oocl.cultivation.parking_personnels;

import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.parking_boy_parking_strategies.SuperSmartParkingStrategy;
import com.oocl.cultivation.parking_personnels.ParkingBoy;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        super.parkingBoyParkingStrategy = new SuperSmartParkingStrategy();
    }
}
