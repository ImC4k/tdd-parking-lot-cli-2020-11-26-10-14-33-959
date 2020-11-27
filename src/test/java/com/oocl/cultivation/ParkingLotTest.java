package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_park_given_a_car_and_with_available_capacity() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_throw_NotEnoughPositionException_when_park_given_a_car_and_with_no_available_capacity() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingLot.park(car));

        //then
        assertEquals("Not enough position", exception.getMessage());
    }

    @Test
    void should_return_parking_tickets_when_park_given_multiple_cars_and_multiple_available_spaces() throws NotEnoughPositionException {
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
    void should_throw_NotEnoughPositionException_parking_ticket_when_park_given_multiple_cars_and_1_available_spaces() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        final ParkingTicket parkingTicket1 = parkingLot.park(car1);

        Exception exceptionFromParkingCar2 = assertThrows(Exception.class, ()-> parkingLot.park(car2));


        assertNotNull(parkingTicket1);
        assertEquals("Not enough position", exceptionFromParkingCar2.getMessage());
    }

    @Test
    void should_return_car_when_fetch_given_parking_ticket_valid() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
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
    void should_throw_UnrecognizedParkingTicketException_when_fetch_given_parking_ticket_is_used() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingLot.fetch(ticket));

        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_UnrecognizedParkingTicketException_when_fetch_given_parking_ticket_is_invalid() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        ParkingTicket selfCreatedTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingLot.fetch(selfCreatedTicket));

        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_UnrecognizedParkingTicketException_when_fetch_given_parking_ticket_is_null() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingLot.fetch(null));

        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    public void should_return_size_of_capacity_when_getCapacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);

        //when
        Integer capacity = parkingLot.getCapacity();

        //then
        assertEquals(3, capacity);
    }

}
