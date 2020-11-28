package com.oocl.cultivation;

import java.util.List;

public class StandardFetchingStrategy implements ParkingBoyFetchingStrategy {
    @Override
    public Car fetch(ParkingTicket ticket, List<ParkingLot> parkingLots) throws UnrecognizedParkingTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetch(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {}
        }
        throw new UnrecognizedParkingTicketException();
    }
}
