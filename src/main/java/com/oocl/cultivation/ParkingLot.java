package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Integer CAPACITY;
    private Map<ParkingTicket, Car> parkedCars;

    public ParkingLot(Integer CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.parkedCars = new HashMap<>();
    }


    private boolean isVacant() {
        return parkedCars.size() < CAPACITY;
    }

    public ParkingTicket park(Car car) {
        if (isVacant()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedCars.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        return parkedCars.get(ticket);
    }
}
