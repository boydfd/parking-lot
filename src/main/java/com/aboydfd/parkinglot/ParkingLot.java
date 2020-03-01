package com.aboydfd.parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    Set<Car> parkedCars = new HashSet<>();
    public void park(Car car) {
        parkedCars.add(car);
    }

    boolean isExist(Car car) {
        return parkedCars.contains(car);
    }
}
