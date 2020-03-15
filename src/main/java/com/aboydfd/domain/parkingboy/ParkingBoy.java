package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkinglot.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ParkingBoy {
    private Map<ParkingLotId, ParkingLot> parkingLots;
    private final NaturalParkingOrder naturalParkingOrder;
    private final Set<Ticket> tickets = new HashSet<>();

    public ParkingBoy(List<ParkingLot> parkingLots,
                      NaturalParkingOrder naturalParkingOrder) {
        this.parkingLots = parkingLots.stream().collect(toMap(ParkingLot::getId, identity()));
        this.naturalParkingOrder = naturalParkingOrder;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = selectParkingLot();
        parkingLot.park(car);
        String validationNumber = "any vn";
        Ticket ticket = new Ticket(validationNumber, parkingLot.getId(), car);
        tickets.add(ticket);
        return ticket;
    }

    private ParkingLot selectParkingLot() {
        return parkingLots.get(naturalParkingOrder.getNextParkingLotId());
    }

    public Car takeBackCarWith(Ticket ticket) {
        if (!tickets.contains(ticket)) {
            throw new ReceiptInvalidException();
        }

        Car car = parkingLots
                .get(ticket.getParkingLotId())
                .takeBackCar(ticket.getCar());
        tickets.remove(ticket);
        return car;
    }
}
