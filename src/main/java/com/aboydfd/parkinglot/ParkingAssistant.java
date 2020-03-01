package com.aboydfd.parkinglot;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ParkingAssistant {
    private Map<ParkingLotId, ParkingLot> parkingLots;
    private final NaturalParkingOrder naturalParkingOrder;

    public ParkingAssistant(List<ParkingLot> parkingLots,
                            NaturalParkingOrder naturalParkingOrder) {
        this.parkingLots = parkingLots.stream().collect(toMap(ParkingLot::getId, identity()));
        this.naturalParkingOrder = naturalParkingOrder;
    }

    public Receipt park(Car car) {
        ParkingLot parkingLot = selectParkingLot();
        parkingLot.park(car);
        String validationNumber = "any vn";
        return new Receipt(validationNumber, parkingLot.getId(), car);
    }

    private ParkingLot selectParkingLot() {
        return parkingLots.get(naturalParkingOrder.getNextParkingLotId());
    }
}
