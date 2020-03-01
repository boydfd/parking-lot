package com.aboydfd.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void limit_is_not_reach___park_a_car___car_added() {
        Car car = new Car("1");
        Car car2 = new Car("1");
        ParkingLot parkingLot = new ParkingLot();
        assertFalse(parkingLot.isExist(car2));
        parkingLot.park(car);
        assertTrue(parkingLot.isExist(car2));
    }
}