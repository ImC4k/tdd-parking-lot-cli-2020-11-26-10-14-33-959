package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_parking_ticket_when_park_given_a_car_and_with_available_capacity() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parking_ticket_when_park_given_a_car_and_with_no_available_capacity() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNull(parkingTicket);
    }

}
