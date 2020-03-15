package com.aboydfd.domain.parkinglot;

import com.aboydfd.domain.Entity;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot implements Entity<ParkingLotId> {
    private int space;
    private final ParkingLotId parkingLotId;
    private Set<Car> parkedCars = new HashSet<>();
    private final Set<Ticket> tickets = new HashSet<>();

    public ParkingLot(int space, ParkingLotId parkingLotId) {
        this.space = space;
        this.parkingLotId = parkingLotId;
    }

    public Ticket park(Car car) {
        limitationCheck();
        parkedCars.add(car);
        String validationNumber = "any vn";
        Ticket ticket = new Ticket(validationNumber, getId(), car);
        tickets.add(ticket);
        return ticket;
    }

    private void limitationCheck() {
        if (!isAvailable()) {
            throw new MaxCarLimitReachedException();
        }
    }

    public boolean isAvailable() {
        return space > parkedCars.size();
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

    public Car takeBackCar(Ticket ticket) {
        if (!tickets.contains(ticket)) {
            throw new ReceiptInvalidException();
        }

        Car car = takeBackCar(ticket.getCar());
        tickets.remove(ticket);
        return car;
    }
}
