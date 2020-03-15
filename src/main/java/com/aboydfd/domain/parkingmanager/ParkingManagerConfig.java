package com.aboydfd.domain.parkingmanager;

import com.aboydfd.domain.Entity;
import com.aboydfd.domain.parkingboy.ParkingBoyId;

import java.util.List;

public class ParkingManagerConfig implements Entity<ParkingManagerId> {
    private ParkingManagerId id;
    private final List<ParkingBoyId> parkingBoys;

    public ParkingManagerConfig(ParkingManagerId id, List<ParkingBoyId> parkingBoys) {
        this.id = id;
        this.parkingBoys = parkingBoys;
    }

    @Override
    public ParkingManagerId getId() {
        return id;
    }

    public List<ParkingBoyId> getParkingBoys() {
        return parkingBoys;
    }
}
