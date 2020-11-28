package com.oocl.cultivation;

import java.util.List;

public interface ParkingBoyParkingStrategy {
    ParkingTicket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException;
}
