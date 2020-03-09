package com.aboydfd.domain.parkinglot;

import com.aboydfd.domain.parkingboy.NaturalParkingOrder;
import com.aboydfd.domain.parkingboy.ParkingBoy;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void parking_lot_is_available___parking_a_car_by_parking_assistant___receipt_received() {
        ParkingLot parkingLot = new ParkingLot(1, new ParkingLotId("pli 1"));
        Car car = new Car("1");
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(parkingLot),
                new NaturalParkingOrder(newArrayList(new ParkingLotId("pli 1")), 0));
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket.getValidationNumber());
        assertEquals(car, ticket.getCar());
        assertEquals(new ParkingLotId("pli 1"), ticket.getParkingLotId());
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
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot, parkingLot2), naturalParkingOrder);
        Ticket ticket = parkingBoy.park(car);
        Ticket ticket2 = parkingBoy.park(car2);
        Ticket ticket3 = parkingBoy.park(car3);
        assertEquals(parkingLotId1, ticket.getParkingLotId());
        assertEquals(parkingLotId2, ticket2.getParkingLotId());
        assertEquals(parkingLotId1, ticket3.getParkingLotId());
    }

    @Test
    void car_is_parked___take_back_car_with_correct_receipt___car_can_be_took_back() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        ParkingLotId parkingLotId2 = new ParkingLotId("pli 2");
        ParkingLot parkingLot2 = new ParkingLot(1, parkingLotId2);
        NaturalParkingOrder naturalParkingOrder =
                new NaturalParkingOrder(newArrayList(parkingLotId1, parkingLotId2), 1);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot, parkingLot2), naturalParkingOrder);
        Car car = new Car("1");
        Ticket ticket = parkingBoy.park(car);
        Car carTookBack = parkingBoy.takeBackCarWith(ticket);
        assertEquals(car, carTookBack);
    }

    @Test
    void car_is_parked___take_back_car_with_invalid_receipt___exception_is_thrown() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        ParkingLotId parkingLotId2 = new ParkingLotId("pli 2");
        ParkingLot parkingLot2 = new ParkingLot(1, parkingLotId2);
        NaturalParkingOrder naturalParkingOrder =
                new NaturalParkingOrder(newArrayList(parkingLotId1, parkingLotId2), 1);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot, parkingLot2), naturalParkingOrder);
        Car car = new Car("1");
        parkingBoy.park(car);
        Ticket invalidTicket = new Ticket("invalid number", parkingLotId2, car);
        assertThrows(ReceiptInvalidException.class, () -> parkingBoy.takeBackCarWith(invalidTicket));
    }

    @Test
    void car_is_already_took___take_back_car_with_last_receipt___exception_is_thrown() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        ParkingLotId parkingLotId2 = new ParkingLotId("pli 2");
        ParkingLot parkingLot2 = new ParkingLot(1, parkingLotId2);
        NaturalParkingOrder naturalParkingOrder =
                new NaturalParkingOrder(newArrayList(parkingLotId1, parkingLotId2), 1);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot, parkingLot2), naturalParkingOrder);
        Car car = new Car("1");
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.takeBackCarWith(ticket);
        assertThrows(ReceiptInvalidException.class, () -> parkingBoy.takeBackCarWith(ticket));
    }
}