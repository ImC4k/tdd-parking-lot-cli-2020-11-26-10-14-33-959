package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_true_when_isVacant_given_available_space() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Boolean actual = parkingLot.isVacant();

        //then
        assertTrue(actual);
    }

}
