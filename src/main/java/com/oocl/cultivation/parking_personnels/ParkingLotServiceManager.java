package com.oocl.cultivation.parking_personnels;

import com.oocl.cultivation.*;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

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
        if (isInvalidParkingBoyIndex(parkingBoyIndex)) {
            return null;
        }
        return this.managementList.get(parkingBoyIndex).park(car);
    }

    public Car askParkingBoyWithIndexToFetch(int parkingBoyIndex, ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        if (isInvalidParkingBoyIndex(parkingBoyIndex)) {
            return null;
        }
        return this.managementList.get(parkingBoyIndex).fetch(ticket);
    }

    private boolean isInvalidParkingBoyIndex(int parkingBoyIndex) {
        return parkingBoyIndex < 0 || parkingBoyIndex >= this.managementList.size();
    }
}
