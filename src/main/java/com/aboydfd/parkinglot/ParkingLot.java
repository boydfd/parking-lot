package com.aboydfd.parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private final int limit;
    Set<Car> parkedCars = new HashSet<>();

    public ParkingLot(int limit) {
        this.limit = limit;
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
}
