package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.*;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public class ParkingBoy implements ParkableAndFetchable {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        return parkingLots.stream().filter(parkingLot -> parkingLot.getAvailableSpace() > 0).findFirst().orElseThrow(NotEnoughPositionException::new).park(car);
    }

    @Override
    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetch(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {}
        }
        throw new UnrecognizedParkingTicketException();
    }
}
