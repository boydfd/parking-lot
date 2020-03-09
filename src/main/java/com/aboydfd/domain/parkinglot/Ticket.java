package com.aboydfd.domain.parkinglot;

import java.util.Objects;

public class Ticket {
    private final String validationNumber;
    private final ParkingLotId parkingLotId;
    private final Car car;

    public Ticket(String validationNumber, ParkingLotId parkingLotId, Car car) {
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
        Ticket ticket = (Ticket) o;
        return Objects.equals(validationNumber, ticket.validationNumber) &&
                Objects.equals(parkingLotId, ticket.parkingLotId) &&
                Objects.equals(car, ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validationNumber, parkingLotId, car);
    }
}
