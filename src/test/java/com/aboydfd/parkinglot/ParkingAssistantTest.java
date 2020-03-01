package com.aboydfd.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ParkingAssistantTest {
    @Test
    void parking_lot_is_available___parking_a_car_by_parking_assistant___receipt_received() {
        ParkingLot parkingLot = new ParkingLot(1, new ParkingLotId("pli 1"));
        Car car = new Car("1");
        ParkingAssistant parkingAssistant = new ParkingAssistant(newArrayList(parkingLot));
        Receipt receipt = parkingAssistant.park(car);
        assertNotNull(receipt.getValidationNumber());
        assertEquals(car, receipt.getCar());
        assertEquals(new ParkingLotId("pli 1"), receipt.getParkingLotId());
    }

}