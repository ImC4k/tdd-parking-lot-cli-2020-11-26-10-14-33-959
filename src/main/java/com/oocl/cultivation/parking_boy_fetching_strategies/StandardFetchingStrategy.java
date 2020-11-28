package com.oocl.cultivation.parking_boy_fetching_strategies;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.UnrecognizedParkingTicketException;
import com.oocl.cultivation.parking_boy_fetching_strategies.ParkingBoyFetchingStrategy;

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
