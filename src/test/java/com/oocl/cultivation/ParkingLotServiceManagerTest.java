package com.oocl.cultivation;

import com.oocl.cultivation.parkable_and_fetchables.ParkableAndFetchable;
import com.oocl.cultivation.parkable_and_fetchables.ParkingLot;
import com.oocl.cultivation.parking_boy_fetching_behaviors.StandardParkingBoyFetchingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.SmartParkingBoyParkingStrategy;
import com.oocl.cultivation.parking_boy_parking_behaviors.StandardParkingBoyParkingBehavior;
import com.oocl.cultivation.parking_boy_parking_behaviors.SuperSmartParkingBoyParkingBehavior;
import com.oocl.cultivation.parking_lot_exceptions.NotEnoughPositionException;
import com.oocl.cultivation.parking_lot_exceptions.UnrecognizedParkingTicketException;
import com.oocl.cultivation.parkable_and_fetchables.ParkingBoy;
import com.oocl.cultivation.parkable_and_fetchables.ParkingLotServiceManager;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceManagerTest {
    @Test
    void should_be_able_to_add_parking_boy_to_management_list_when_addToManagementList_given_a_ParkableAndFetchable() throws NotEnoughPositionException {
        //given
        ParkableAndFetchable parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)), new StandardParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Stream.of(new ParkingLot(10)).collect(Collectors.toList()));

        //when
        manager.addToManagementList(parkingBoy);

        //then
        assertNotNull(manager.park(new Car()));
    }

    @Test
    void should_be_able_to_park_to_parking_lot_when_park_given_managers_managementList_contains_only_a_parking_lot() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(parkingLot));

        //when
        manager.park(new Car());

        //then
        assertEquals(9, parkingLot.getAvailableSpace());
    }

    @Test
    void should_be_able_to_fetch_from_parking_lot_when_fetch_given_managers_managementList_contains_only_a_parking_lot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(parkingLot));
        Car car = new Car();
        ParkingTicket ticket = manager.park(car);

        //when
        Car actual = manager.fetch(ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    void should_be_able_to_park_to_second_parking_lot_when_park_given_managers_managementList_contains_multiple_ParkableAndFetchable_and_first_entity_cant_be_parked() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot parkingLotForParkingBoy = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLotForParkingBoy), new SmartParkingBoyParkingStrategy(), new StandardParkingBoyFetchingBehavior());
        ParkingLotServiceManager manager = new ParkingLotServiceManager(Stream.of(parkingLot, parkingBoy).collect(Collectors.toList()));

        //when
        manager.park(new Car());

        //then
        assertEquals(9, parkingLotForParkingBoy.getAvailableSpace());
    }

    @Test
    void should_be_able_to_fetch_from_second_parking_lot_when_park_given_managers_managementList_contains_multiple_ParkableAndFetchable_and_the_car_is_parked_to_second() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot parkingLotForParkingBoy = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLotForParkingBoy), new SuperSmartParkingBoyParkingBehavior(), new StandardParkingBoyFetchingBehavior());
        ParkingLotServiceManager manager = new ParkingLotServiceManager(Stream.of(parkingLot, parkingBoy).collect(Collectors.toList()));
        Car car = new Car();
        ParkingTicket ticket = manager.park(car);

        //when
        Car actual = manager.fetch(ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    void should_park_car_to_first_parking_lot_when_park_given_3_parking_lots_are_free_but_first_ones_available_position_rate_is_lowest() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(10);
        ParkingLotServiceManager manager = new ParkingLotServiceManager(Stream.of(parkingLot1, parkingLot2, parkingLot3).collect(Collectors.toList()));

        // parking lot 1 is 1/10
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());

        // parking lot 2 is 3/10
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());

        // parking lot 3 is 5/10
        parkingLot3.park(new Car());
        parkingLot3.park(new Car());
        parkingLot3.park(new Car());
        parkingLot3.park(new Car());
        parkingLot3.park(new Car());

        //when
        manager.park(new Car());

        //then
        assertEquals(0, parkingLot1.getAvailableSpace());
        assertEquals(3, parkingLot2.getAvailableSpace());
        assertEquals(5, parkingLot3.getAvailableSpace());
    }
}
