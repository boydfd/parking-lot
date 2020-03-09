package com.aboydfd.domain.parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private int space;
    private final ParkingLotId parkingLotId;
    private Set<Car> parkedCars = new HashSet<>();

    public ParkingLot(int space, ParkingLotId parkingLotId) {
        this.space = space;
        this.parkingLotId = parkingLotId;
    }

    public void park(Car car) {
        limitationCheck();
        parkedCars.add(car);
    }

    private void limitationCheck() {
        if (space <= parkedCars.size()) {
            throw new MaxCarLimitReachedException();
        }
    }

    boolean isExist(Car car) {
        return parkedCars.contains(car);
    }

    public ParkingLotId getId() {
        return parkingLotId;
    }

    public Car takeBackCar(Car car) {
        parkedCars.remove(car);
        return car;
    }
}
