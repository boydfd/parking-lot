package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkingboy.NaturalParkingOrder;
import com.aboydfd.domain.parkingboy.ParkingBoy;
import com.aboydfd.domain.parkinglot.Car;
import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotId;
import com.aboydfd.domain.parkinglot.Ticket;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    void
    parking_order_is_natural_order___parking_cars_by_parking_boy___car_parked_to_correct_parking_lot_in_turn() {
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
        Ticket ticket = parkingBoy.selectParkingLot().park(car);
        Ticket ticket2 = parkingBoy.selectParkingLot().park(car2);
        Ticket ticket3 = parkingBoy.selectParkingLot().park(car3);
        assertEquals(parkingLotId1, ticket.getParkingLotId());
        assertEquals(parkingLotId2, ticket2.getParkingLotId());
        assertEquals(parkingLotId1, ticket3.getParkingLotId());
    }
}