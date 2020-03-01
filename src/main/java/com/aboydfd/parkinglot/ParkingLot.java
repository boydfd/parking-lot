package com.aboydfd.parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private int limit;
    private final ParkingLotId parkingLotId;
    private Set<Car> parkedCars = new HashSet<>();

    public ParkingLot(int limit, ParkingLotId parkingLotId) {
        this.limit = limit;
        this.parkingLotId = parkingLotId;
    }

    public void park(Car car) {
        limitationCheck();
        parkedCars.add(car);
    }

    private void limitationCheck() {
        if (limit <= parkedCars.size()) {
            throw new MaxCarLimitReachedException();
        }
    }

    boolean isExist(Car car) {
        return parkedCars.contains(car);
    }

    ParkingLotId getId() {
        return parkingLotId;
    }
}
