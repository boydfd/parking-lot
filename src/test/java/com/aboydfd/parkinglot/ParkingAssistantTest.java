package com.aboydfd.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingAssistantTest {
    @Test
    void parking_lot_is_available___parking_a_car_by_parking_assistant___receipt_received() {
        ParkingLot parkingLot = new ParkingLot(1, new ParkingLotId("pli 1"));
        Car car = new Car("1");
        ParkingAssistant parkingAssistant = new ParkingAssistant(newArrayList(parkingLot),
                new NaturalParkingOrder(newArrayList(new ParkingLotId("pli 1")), 0));
        Receipt receipt = parkingAssistant.park(car);
        assertNotNull(receipt.getValidationNumber());
        assertEquals(car, receipt.getCar());
        assertEquals(new ParkingLotId("pli 1"), receipt.getParkingLotId());
    }

    @Test
    void
    parking_order_is_natural_order___parking_cars_by_parking_assistant___car_parked_to_correct_parking_lot_in_turn() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        ParkingLotId parkingLotId2 = new ParkingLotId("pli 2");
        ParkingLot parkingLot2 = new ParkingLot(1, parkingLotId2);
        NaturalParkingOrder naturalParkingOrder =
                new NaturalParkingOrder(newArrayList(parkingLotId1, parkingLotId2), 0);
        Car car = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        ParkingAssistant parkingAssistant =
                new ParkingAssistant(newArrayList(parkingLot, parkingLot2), naturalParkingOrder);
        Receipt receipt = parkingAssistant.park(car);
        Receipt receipt2 = parkingAssistant.park(car2);
        Receipt receipt3 = parkingAssistant.park(car3);
        assertEquals(parkingLotId1, receipt.getParkingLotId());
        assertEquals(parkingLotId2, receipt2.getParkingLotId());
        assertEquals(parkingLotId1, receipt3.getParkingLotId());
    }
}