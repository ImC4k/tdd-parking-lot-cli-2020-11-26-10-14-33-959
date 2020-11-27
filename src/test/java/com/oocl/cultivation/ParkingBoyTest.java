package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_given_a_car_and_parking_lot_has_available_space() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car = new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_null_when_park_given_a_car_and_parking_lot_has_no_available_space() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(0));
        Car car = new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNull(ticket);
    }

}
