package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {
    @Test
    public void should_call_parking_lot_fetch_when_fetch() {
        //given
        ParkingLot parkingLotMock = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotMock);
        Car car = new Car();
        ParkingTicket parckingTicket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(parckingTicket);

        //then
        verify(parkingLotMock, times(1)).fetch(parckingTicket);
    }

    @Test
    public void should_call_parking_lot_park_when_park() {
        //given
        ParkingLot parkingLotMock = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotMock);
        Car car = new Car();
        //when
        ParkingTicket parckingTicket = parkingBoy.park(car);

        //then
        verify(parkingLotMock, times(1)).park(car);
    }

}
