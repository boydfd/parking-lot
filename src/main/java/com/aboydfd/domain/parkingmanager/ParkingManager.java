package com.aboydfd.domain.parkingmanager;

import com.aboydfd.domain.parkingboy.ParkingBoy;

import java.util.List;
import java.util.Optional;

public class ParkingManager {
    private final List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Optional<ParkingBoy> findAvailableParkingBoy() {
        return parkingBoys.stream().filter(ParkingBoy::isAvailable).findAny();
    }
}
