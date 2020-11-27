package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy {
    private List<ParkingBoy> managementList;

    public ParkingLotServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.managementList = new ArrayList<>();
    }

    public void addToManagementList(ParkingBoy smartParkingBoy) {
    }

    public List<ParkingBoy> getManagementList() {
        return this.managementList;
    }
}
