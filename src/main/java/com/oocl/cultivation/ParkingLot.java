package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final Integer CAPACITY;
    private List<Car> parkedCars;

    public ParkingLot(Integer CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.parkedCars = new ArrayList<>();
    }


    public Boolean isVacant() {
        return parkedCars.size() < CAPACITY;
    }

    public ParkingTicket park(Car car) {
        return null;
    }
}
