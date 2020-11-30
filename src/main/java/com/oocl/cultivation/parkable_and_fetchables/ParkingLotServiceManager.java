package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.*;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public class ParkingLotServiceManager implements ParkableAndFetchable {
    private final List<ParkableAndFetchable> managementList;

    public ParkingLotServiceManager(List<ParkableAndFetchable> parkableAndFetchables) {
        this.managementList = parkableAndFetchables;
    }

    public void addToManagementList(ParkableAndFetchable parkableAndFetchable) {
        managementList.add(parkableAndFetchable);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        for (ParkableAndFetchable parkableAndFetchable : managementList) {
            try {
                return parkableAndFetchable.park(car);
            }
            catch (NotEnoughPositionException ignored) {}
        }
        throw new NotEnoughPositionException();
    }

    @Override
    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        for (ParkableAndFetchable parkableAndFetchable : managementList) {
            try {
                return parkableAndFetchable.fetch(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {}
        }
        throw new UnrecognizedParkingTicketException();
    }
}
