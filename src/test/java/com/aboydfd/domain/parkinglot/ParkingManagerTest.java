package com.aboydfd.domain.parkinglot;

import com.aboydfd.domain.parkingboy.NaturalParkingOrder;
import com.aboydfd.domain.parkingboy.ParkingBoy;
import com.aboydfd.domain.parkingmanager.ParkingManager;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingManagerTest {
    @Test
    void created_parking_manager___find_a_parking_boy___parking_boy_returned() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        NaturalParkingOrder naturalParkingOrder =
                new NaturalParkingOrder(newArrayList(parkingLotId1), 0);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot), naturalParkingOrder);
        ParkingManager parkingManager = new ParkingManager(newArrayList(parkingBoy));
        ParkingBoy availableParkingBoy = parkingManager.findAvailableParkingBoy();
        assertNotNull(availableParkingBoy);
    }
}
