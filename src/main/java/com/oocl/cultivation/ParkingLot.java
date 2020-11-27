package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Integer CAPACITY;
    private final Map<ParkingTicket, Car> parkedCars;

    public ParkingLot(Integer CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.parkedCars = new HashMap<>();
    }


    private boolean isVacant() {
        return parkedCars.size() < CAPACITY;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        if (isVacant()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedCars.put(parkingTicket, car);
            return parkingTicket;
        }
        throw new NotEnoughPositionException();
    }

    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException{
        if (ticket == null || !parkedCars.containsKey(ticket)) {
            throw new UnrecognizedParkingTicketException();
        }
        return parkedCars.remove(ticket);
    }

    public Integer getCapacity() {
        return this.CAPACITY;
    }

    public Integer getAvailableSpace() {
        return null;
    }
}
