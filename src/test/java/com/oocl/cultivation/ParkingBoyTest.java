package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {
    @Test
    void should_call_parking_lot_fetch_when_fetch() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //given
        ParkingLot parkingLotMock = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLotMock).collect(Collectors.toList()));
        Car car = new Car();
        ParkingTicket parckingTicket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(parckingTicket);

        //then
        verify(parkingLotMock, times(1)).fetch(parckingTicket);
    }

    @Test
    void should_call_parking_lot_park_when_park() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLotMock = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLotMock).collect(Collectors.toList()));
        Car car = new Car();
        //when
        parkingBoy.park(car);

        //then
        verify(parkingLotMock, times(1)).park(car);
    }

    @Test
    public void should_park_to_second_parking_low_when_park_given_first_parking_lot_is_full_and_second_is_vacant() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()));

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_fetch_from_second_parking_low_when_park_given_car_is_parked_to_second_parking_lot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()));
        ParkingTicket ticket = parkingBoy.park(car);

        //when
        Car actual = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    public void should_throw_NotEnoughPositionException_when_park_given_all_parking_slots_are_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()));

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingBoy.park(car));

        //then
        assertEquals("Not enough position", exception.getMessage());
    }

}
