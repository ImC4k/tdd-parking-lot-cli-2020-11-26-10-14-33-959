package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.parking_boy_fetching_behaviors.ParkingBoyFetchingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.ParkingBoyParkingBehavior;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots, ParkingBoyParkingBehavior parkingBoyParkingBehavior, ParkingBoyFetchingBehavior parkingBoyFetchingBehavior) {
        super(parkingLots, parkingBoyParkingBehavior, parkingBoyFetchingBehavior);
    }
}
