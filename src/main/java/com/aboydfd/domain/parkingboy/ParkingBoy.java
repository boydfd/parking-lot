package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkinglot.*;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ParkingBoy {
    private Map<ParkingLotId, ParkingLot> parkingLots;
    private final ParkingStrategy parkingStrategy;

    public ParkingBoy(List<ParkingLot> parkingLots,
                      ParkingStrategy parkingStrategy) {
        this.parkingLots = parkingLots.stream().collect(toMap(ParkingLot::getId, identity()));
        this.parkingStrategy = parkingStrategy;
    }

    public boolean isAvailable() {
        return parkingLots.values().stream().anyMatch(ParkingLot::isAvailable);
    }

    public ParkingLot selectParkingLot() {
        return parkingLots.get(parkingStrategy.getNextParkingLotId());
    }

}
