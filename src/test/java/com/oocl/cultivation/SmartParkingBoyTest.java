package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_in_second_parking_lot_when_park_given_first_available_space_is_3_and_second_available_space_is_5_and_third_available_space_is_4() throws NotEnoughPositionException {
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

}
