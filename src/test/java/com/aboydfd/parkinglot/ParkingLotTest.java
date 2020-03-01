package com.aboydfd.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void limit_is_not_reach___park_a_car___car_added() {
        Car car = new Car("1");
        Car car2 = new Car("1");
        ParkingLot parkingLot = new ParkingLot(10);
        assertFalse(parkingLot.isExist(car2));
        parkingLot.park(car);
        assertTrue(parkingLot.isExist(car2));
    }

    @Test
    void parking_lot_reaching_limit_parking_car_number___park_a_car___throw_limit_reach_exception() {
        Car car = new Car("1");
        Car car2 = new Car("2");
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        assertThrows(MaxCarLimitReachedException.class, () -> parkingLot.park(car2));
    }
}