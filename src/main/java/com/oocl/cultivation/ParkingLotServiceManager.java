package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy {
    private final List<ParkingBoy> managementList;

    public ParkingLotServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.managementList = new ArrayList<>();
    }

    public void addToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList() {
        return this.managementList;
    }

    public ParkingTicket askParkingBoyWithIndexToPark(int parkingBoyIndex, Car car) throws NotEnoughPositionException {
        if (parkingBoyIndex < 0 || parkingBoyIndex >= this.managementList.size()) {
            return null;
        }
        return this.managementList.get(parkingBoyIndex).park(car);
    }

    public Car askParkingBoyWithIndexToFetch(int parkingBoyIndex, ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        if (parkingBoyIndex < 0 || parkingBoyIndex >= this.managementList.size()) {
            return null;
        }
        return this.managementList.get(parkingBoyIndex).fetch(ticket);
    }
}
