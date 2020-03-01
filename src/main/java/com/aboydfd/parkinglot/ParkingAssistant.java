package com.aboydfd.parkinglot;

import java.util.List;

public class ParkingAssistant {
    private List<ParkingLot> parkingLots;

    public ParkingAssistant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        ParkingLot parkingLot = selectParkingLot();
        parkingLot.park(car);
        String validationNumber = "any vn";
        return new Receipt(validationNumber, parkingLot.getId(), car);
    }

    private ParkingLot selectParkingLot() {
        return parkingLots.get(0);
    }
}
