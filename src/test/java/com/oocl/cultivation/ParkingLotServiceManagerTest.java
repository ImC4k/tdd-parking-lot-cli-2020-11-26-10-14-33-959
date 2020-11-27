package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
