package com.oocl.cultivation;

import java.util.List;

public interface ParkingBoyFetchingStrategy {
    Car fetch(ParkingTicket ticket, List<ParkingLot> parkingLots) throws UnrecognizedParkingTicketException;
}
