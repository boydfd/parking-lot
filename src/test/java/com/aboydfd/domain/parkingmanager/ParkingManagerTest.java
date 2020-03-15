package com.aboydfd.domain.parkingmanager;

import com.aboydfd.domain.parkingboy.NaturalParkingStrategy;
import com.aboydfd.domain.parkingboy.ParkingBoy;
import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotId;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    @Test
    void at_least_1_parking_boy_available___find_a_parking_boy___parking_boy_returned() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(2, parkingLotId1);
        NaturalParkingStrategy naturalParkingStrategy =
                new NaturalParkingStrategy(newArrayList(parkingLotId1), 0);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot), naturalParkingStrategy);
        ParkingManager parkingManager = new ParkingManager(newArrayList(parkingBoy));

        Optional<ParkingBoy> availableParkingBoy = parkingManager.findAvailableParkingBoy();
        assertTrue(availableParkingBoy.isPresent());
        assertNotNull(availableParkingBoy.get());
    }

    @Test
    void no_available_parking_boy___find_a_parking_boy___null_returned() {
        ParkingLotId parkingLotId1 = new ParkingLotId("pli 1");
        ParkingLot parkingLot = new ParkingLot(0, parkingLotId1);
        NaturalParkingStrategy naturalParkingStrategy =
                new NaturalParkingStrategy(newArrayList(parkingLotId1), 0);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot), naturalParkingStrategy);
        ParkingManager parkingManager = new ParkingManager(newArrayList(parkingBoy));
        assertFalse(parkingManager.findAvailableParkingBoy().isPresent());
    }
}
