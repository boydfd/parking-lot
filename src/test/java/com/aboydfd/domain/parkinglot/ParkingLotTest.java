package com.aboydfd.domain.parkinglot;

import com.aboydfd.domain.parkingboy.NaturalParkingOrder;
import com.aboydfd.domain.parkingboy.ParkingBoy;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void limit_is_not_reach___park_a_car___car_added_and_ticket_received() {
        Car car = new Car("1");
        Car car2 = new Car("1");
        ParkingLot parkingLot = new ParkingLot(10, new ParkingLotId("pli 1"));
        assertFalse(parkingLot.isExist(car2));
        Ticket ticket = parkingLot.park(car);
        assertTrue(parkingLot.isExist(car2));
        assertNotNull(ticket.getValidationNumber());
        assertEquals(car, ticket.getCar());
        assertEquals(new ParkingLotId("pli 1"), ticket.getParkingLotId());
    }

    @Test
    void car_is_parked___take_back_car_with_correct_ticket___car_can_be_took_back() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        Car car = new Car("1");
        Ticket ticket = parkingLot.park(car);
        Car carTookBack = parkingLot.takeBackCar(ticket);
        assertEquals(car, carTookBack);
    }

    @Test
    void car_is_parked___take_back_car_with_invalid_ticket___exception_is_thrown() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        Car car = new Car("1");
        parkingLot.park(car);
        Ticket invalidTicket = new Ticket("invalid number", parkingLotId1, car);
        assertThrows(ReceiptInvalidException.class, () -> parkingLot.takeBackCar(invalidTicket));
    }

    @Test
    void car_is_already_took___take_back_car_with_last_ticket___exception_is_thrown() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        Car car = new Car("1");
        Ticket ticket = parkingLot.park(car);
        parkingLot.takeBackCar(ticket);
        assertThrows(ReceiptInvalidException.class, () -> parkingLot.takeBackCar(ticket));
    }

    @Test
    void parking_lot_reaching_limit_parking_car_number___park_a_car___throw_limit_reach_exception() {
        Car car = new Car("1");
        Car car2 = new Car("2");
        ParkingLot parkingLot = new ParkingLot(1, new ParkingLotId("pli 1"));
        parkingLot.park(car);
        assertThrows(MaxCarLimitReachedException.class, () -> parkingLot.park(car2));
    }
}