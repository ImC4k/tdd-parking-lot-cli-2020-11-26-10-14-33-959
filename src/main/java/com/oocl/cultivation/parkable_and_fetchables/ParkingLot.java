package com.oocl.cultivation.parkable_and_fetchables;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingTicket;
import com.oocl.cultivation.parkable_and_fetchables.ParkableAndFetchable;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkableAndFetchable {
    private final Integer CAPACITY;
    private final Map<ParkingTicket, Car> parkedCars;

    public ParkingLot(Integer CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.parkedCars = new HashMap<>();
    }


    private boolean isVacant() {
        return parkedCars.size() < CAPACITY;
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        if (isVacant()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedCars.put(parkingTicket, car);
            return parkingTicket;
        }
        throw new NotEnoughPositionException();
    }

    @Override
    public Car fetch(ParkingTicket ticket) throws UnrecognizedParkingTicketException {
        if (ticket == null || !parkedCars.containsKey(ticket)) {
            throw new UnrecognizedParkingTicketException();
        }
        return parkedCars.remove(ticket);
    }

    public Integer getCapacity() {
        return this.CAPACITY;
    }

    public Integer getAvailableSpace() {
        return this.CAPACITY - this.parkedCars.size();
    }
}
