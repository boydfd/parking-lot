package com.aboydfd.parkinglot;

import java.util.Objects;

public class Receipt {
    private final String validationNumber;
    private final ParkingLotId parkingLotId;
    private final Car car;

    public Receipt(String validationNumber, ParkingLotId parkingLotId, Car car) {
        this.validationNumber = validationNumber;
        this.parkingLotId = parkingLotId;
        this.car = car;
    }

    public String getValidationNumber() {
        return validationNumber;
    }

    public ParkingLotId getParkingLotId() {
        return parkingLotId;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Receipt receipt = (Receipt) o;
        return Objects.equals(validationNumber, receipt.validationNumber) &&
                Objects.equals(parkingLotId, receipt.parkingLotId) &&
                Objects.equals(car, receipt.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validationNumber, parkingLotId, car);
    }
}
