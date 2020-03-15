package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkinglot.ParkingLotId;

import java.util.List;

public class NaturalParkingStrategy implements ParkingStrategy {
    private final List<ParkingLotId> parkingLotIds;
    private int currentIndex;

    public NaturalParkingStrategy(List<ParkingLotId> parkingLotIds, int currentIndex) {
        this.parkingLotIds = parkingLotIds;
        this.currentIndex = currentIndex;
    }

    public ParkingLotId getNextParkingLotId() {
        int index = currentIndex++;
        currentIndex = currentIndex % parkingLotIds.size();
        return parkingLotIds.get(index);
    }
}
