package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkinglot.*;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ParkingBoy {
    private Map<ParkingLotId, ParkingLot> parkingLots;
    private final NaturalParkingOrder naturalParkingOrder;

    public ParkingBoy(List<ParkingLot> parkingLots,
                      NaturalParkingOrder naturalParkingOrder) {
        this.parkingLots = parkingLots.stream().collect(toMap(ParkingLot::getId, identity()));
        this.naturalParkingOrder = naturalParkingOrder;
    }

    public boolean isAvailable() {
        return true;
    }

    public ParkingLot selectParkingLot() {
        return parkingLots.get(naturalParkingOrder.getNextParkingLotId());
    }

}
