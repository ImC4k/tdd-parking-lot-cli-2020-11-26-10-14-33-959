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

    @Test
    public void should_return_parking_tickets_when_park_given_multiple_cars_and_multiple_available_spaces() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(5);

        //when
        final ParkingTicket parkingTicket1 = parkingLot.park(car1);
        final ParkingTicket parkingTicket2 = parkingLot.park(car2);

        //then
        assertNotNull(parkingTicket1);
        assertNotNull(parkingTicket2);
    }


}
