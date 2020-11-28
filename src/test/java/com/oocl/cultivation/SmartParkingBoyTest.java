package com.oocl.cultivation;

import com.oocl.cultivation.parking_personnels.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartParkingBoyTest {
    @Test
    void should_park_car_in_second_parking_lot_when_park_given_first_available_space_is_3_and_second_available_space_is_5_and_third_available_space_is_4() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(4);
        Car car = new Car();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()));

        //when
        smartParkingBoy.park(car);

        //then
        assertEquals(3, smartParkingBoy.getParkingLots().get(0).getAvailableSpace());
        assertEquals(4, smartParkingBoy.getParkingLots().get(1).getAvailableSpace());
        assertEquals(4, smartParkingBoy.getParkingLots().get(2).getAvailableSpace());
    }

    @Test
    void should_park_car_in_second_parking_lot_when_park_given_first_available_space_is_3_and_second_available_space_is_5_and_third_available_space_is_5() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(5);
        Car car = new Car();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()));

        //when
        smartParkingBoy.park(car);

        //then
        assertEquals(3, smartParkingBoy.getParkingLots().get(0).getAvailableSpace());
        assertEquals(4, smartParkingBoy.getParkingLots().get(1).getAvailableSpace());
        assertEquals(5, smartParkingBoy.getParkingLots().get(2).getAvailableSpace());
    }

    @Test
    void should_throw_NotEnoughPositionException_when_park_given_all_parking_lots_full() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkingLot3 = new ParkingLot(3);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()));

        parkingLot1.park(new Car());

        parkingLot2.park(new Car());
        parkingLot2.park(new Car());

        parkingLot3.park(new Car());
        parkingLot3.park(new Car());
        parkingLot3.park(new Car());

        //when
        Exception exception = assertThrows(Exception.class, ()-> smartParkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position", exception.getMessage());
    }

}
