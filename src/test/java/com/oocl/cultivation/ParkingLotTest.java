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

    @Test
    public void should_return_1_parking_ticket_when_park_given_multiple_cars_and_1_available_spaces() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        final ParkingTicket parkingTicket1 = parkingLot.park(car1);
        final ParkingTicket parkingTicket2 = parkingLot.park(car2);

        //then
        assertNotNull(parkingTicket1);
        assertNull(parkingTicket2);
    }

    @Test
    public void should_return_car_when_fetch_given_parking_ticket_valid() throws UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);

        //when
        final Car actual = parkingLot.fetch(ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    public void should_return_null_when_fetch_given_parking_ticket_is_used() throws UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);

        //when
        Car carFromFetchedAlreadyTicket = parkingLot.fetch(ticket);

        //then
        assertNull(carFromFetchedAlreadyTicket);
    }

    @Test
    public void should_return_null_when_fetch_given_parking_ticket_is_invalid() throws UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        ParkingTicket selfCreatedTicket = new ParkingTicket();

        //when
        Car carFromFetchedAlreadyTicket = parkingLot.fetch(selfCreatedTicket);

        //then
        assertNull(carFromFetchedAlreadyTicket);
    }


}
