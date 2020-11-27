package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.Collections;

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
    void should_throw_NotEnoughPositionException_when_askParkingBoyWithIndexToPark_given_valid_index_and_car() throws NotEnoughPositionException {
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
}
