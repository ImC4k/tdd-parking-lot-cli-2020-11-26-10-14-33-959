package com.oocl.cultivation;

import com.oocl.cultivation.parkable_and_fetchables.ParkingLot;
import com.oocl.cultivation.parking_boy_fetching_behaviors.StandardParkingBoyFetchingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.SuperSmartParkingBoyParkingBehavior;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parkable_and_fetchables.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuperSmartParkingBoyTest {
    @Test
    void should_park_car_in_second_parking_lot_when_park_given_first_available_space_is_5_out_of_10_and_second_available_space_is_3_out_of_4_and_third_available_space_is_4_out_of_6() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(4);
        ParkingLot parkingLot3 = new ParkingLot(6);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()), new SuperSmartParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());

        parkingLot2.park(new Car());

        parkingLot3.park(new Car());
        parkingLot3.park(new Car());

        //when
        superSmartParkingBoy.park(new Car());

        //then
        assertEquals(5, parkingLot1.getAvailableSpace());
        assertEquals(2, parkingLot2.getAvailableSpace());
        assertEquals(4, parkingLot3.getAvailableSpace());
    }

    @Test
    void should_park_car_in_second_parking_lot_when_park_given_first_available_space_is_3_out_of_7_and_second_available_space_is_5_out_of_5_and_third_available_space_is_5_out_of_5() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(7);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(5);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()), new SuperSmartParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());

        //when
        superSmartParkingBoy.park(new Car());

        //then
        assertEquals(3, parkingLot1.getAvailableSpace());
        assertEquals(4, parkingLot2.getAvailableSpace());
        assertEquals(5, parkingLot3.getAvailableSpace());
    }

    @Test
    void should_throw_NotEnoughPositionException_when_park_given_all_parking_lots_full() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkingLot3 = new ParkingLot(3);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()), new SuperSmartParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());

        parkingLot1.park(new Car());

        parkingLot2.park(new Car());
        parkingLot2.park(new Car());

        parkingLot3.park(new Car());
        parkingLot3.park(new Car());
        parkingLot3.park(new Car());

        //when
        Exception exception = assertThrows(Exception.class, ()-> superSmartParkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position", exception.getMessage());
    }
}
