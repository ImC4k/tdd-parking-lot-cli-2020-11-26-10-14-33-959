package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.*;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public class ParkingLotServiceManager implements Parkable {
    private final List<Parkable> managementList;

    public ParkingLotServiceManager(List<Parkable> parkables) {
        this.managementList = parkables;
    }

    public void addToManagementList(Parkable parkable) {
        managementList.add(parkable);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        for (Parkable parkable : managementList) {
            try {
                return parkable.park(car);
            }
            catch (NotEnoughPositionException ignored) {}
        }
        throw new NotEnoughPositionException();
    }

    @Override
    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        for (Parkable parkable : managementList) {
            try {
                return parkable.fetch(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {}
        }
        throw new UnrecognizedParkingTicketException();
    }
}
