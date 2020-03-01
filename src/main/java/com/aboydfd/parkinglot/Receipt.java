package com.aboydfd.parkinglot;

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
}
