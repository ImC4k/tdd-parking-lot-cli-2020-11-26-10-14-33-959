package com.oocl.cultivation;

import com.oocl.cultivation.parking_personnels.ParkingBoy;
import com.oocl.cultivation.parking_personnels.ParkingLotServiceManager;
import com.oocl.cultivation.parking_personnels.SmartParkingBoy;
import com.oocl.cultivation.parking_personnels.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceManagerTest {
    @Test
    void should_be_able_to_add_parking_boy_to_management_list_when_addToManagementList_given_a_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));

        //when
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);

        //then
        assertEquals(3, manager.getManagementList().size());
    }

    @Test
    void should_return_parking_ticket_when_askParkingBoyWithIndexToPark_given_valid_index_and_car() throws NotEnoughPositionException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);
        //when
        ParkingTicket ticket = manager.askParkingBoyWithIndexToPark(0, new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_askParkingBoyWithIndexToPark_given_invalid_index_and_car() throws NotEnoughPositionException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);
        //when
        ParkingTicket ticket = manager.askParkingBoyWithIndexToPark(5, new Car());

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_null_when_askParkingBoyWithIndexToPark_given_negative_index_and_car() throws NotEnoughPositionException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);
        //when
        ParkingTicket ticket = manager.askParkingBoyWithIndexToPark(-1, new Car());

        //then
        assertNull(ticket);
    }

    @Test
    void should_throw_NotEnoughPositionException_when_askParkingBoyWithIndexToPark_given_valid_index_and_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(0)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);

        //when
        Exception exception = assertThrows(Exception.class, ()-> manager.askParkingBoyWithIndexToPark(1, new Car()));

        //then
        assertEquals("Not enough position", exception.getMessage());
    }

    @Test
    void should_return_car_when_askParkingBoyWithIndexToFetch_given_valid_index_and_valid_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);
        Car car = new Car();
        ParkingTicket ticket = manager.askParkingBoyWithIndexToPark(0, car);

        //when
        Car actual = manager.askParkingBoyWithIndexToFetch(0, ticket);

        //then
        assertEquals(car, actual);
    }

    @Test
    void should_return_null_when_askParkingBoyWithIndexToFetch_given_invalid_index() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);
        Car car = new Car();
        ParkingTicket ticket = manager.askParkingBoyWithIndexToPark(0, car);

        //when
        Car actual = manager.askParkingBoyWithIndexToFetch(10, ticket);

        //then
        assertNull(actual);
    }

    @Test
    void should_throw_UnrecognizedParkingTicketException_when_askParkingBoyWithIndexToFetch_given_valid_index_and_invalid_ticket() throws NotEnoughPositionException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(new ParkingLot(10)));
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot(10)));

        ParkingLotServiceManager manager = new ParkingLotServiceManager(Collections.singletonList(new ParkingLot(10)));
        manager.addToManagementList(parkingBoy);
        manager.addToManagementList(smartParkingBoy);
        manager.addToManagementList(superSmartParkingBoy);
        manager.askParkingBoyWithIndexToPark(1, new Car());
        //when
        Exception exception = assertThrows(Exception.class, ()-> manager.askParkingBoyWithIndexToFetch(1, new ParkingTicket()));

        //then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    // todo test manager parks in standard manner
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
