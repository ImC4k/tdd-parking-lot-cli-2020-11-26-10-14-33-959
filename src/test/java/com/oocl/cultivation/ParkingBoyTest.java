package com.oocl.cultivation;

import com.oocl.cultivation.parkable_and_fetchables.ParkingLot;
import com.oocl.cultivation.parking_boy_fetching_behaviors.StandardParkingBoyFetchingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.StandardParkingBoyParkingBehavior;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;
import com.oocl.cultivation.parkable_and_fetchables.ParkingBoy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkingBoyTest {
    @Test
    void should_call_parking_lot_fetch_when_fetch() throws UnrecognizedParkingTicketException, NotEnoughPositionException {
        //given
        ParkingLot parkingLotMock = Mockito.mock(ParkingLot.class);
        when(parkingLotMock.getAvailableSpace()).thenReturn(1);
        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLotMock).collect(Collectors.toList()), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(parkingTicket);

        //then
        verify(parkingLotMock, times(1)).fetch(parkingTicket);
    }

    @Test
    void should_call_parking_lot_park_when_park() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLotMock = Mockito.mock(ParkingLot.class);
        when(parkingLotMock.getAvailableSpace()).thenReturn(1);
        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLotMock).collect(Collectors.toList()), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());
        Car car = new Car();
        //when
        parkingBoy.park(car);

        //then
        verify(parkingLotMock, times(1)).park(car);
    }

    @Test
    void should_park_to_second_parking_low_when_park_given_first_parking_lot_is_full_and_second_is_vacant() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()),
                new StandardParkingBoyParkingBehavior(),
                new StandardParkingBoyFetchingBehavior());

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_from_second_parking_low_when_park_given_car_is_parked_to_second_parking_lot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());
        ParkingTicket ticket = parkingBoy.park(car);

        //when
        Car actual = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    void should_throw_NotEnoughPositionException_when_park_given_all_parking_slots_are_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Car car = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingBoy.park(car));

        //then
        assertEquals("Not enough position", exception.getMessage());
    }

    @Test
    void should_throw_UnrecognizedParkingTicketException_when_fetch_given_null_parking_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);

        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingBoy.fetch(null));

        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_UnrecognizedParkingTicketException_when_fetch_given_invalid_parking_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);

        ParkingBoy parkingBoy = new ParkingBoy(Stream.of(parkingLot1, parkingLot2).collect(Collectors.toList()), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());

        //when
        Exception exception = assertThrows(Exception.class, ()-> parkingBoy.fetch(new ParkingTicket()));

        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

}
