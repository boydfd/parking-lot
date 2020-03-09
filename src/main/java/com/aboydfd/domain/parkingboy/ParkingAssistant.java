package com.aboydfd.domain.parkingboy;


import com.aboydfd.domain.parkinglot.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ParkingAssistant {
    private Map<ParkingLotId, ParkingLot> parkingLots;
    private final NaturalParkingOrder naturalParkingOrder;
    private final Set<Receipt> receipts = new HashSet<>();

    public ParkingAssistant(List<ParkingLot> parkingLots,
                            NaturalParkingOrder naturalParkingOrder) {
        this.parkingLots = parkingLots.stream().collect(toMap(ParkingLot::getId, identity()));
        this.naturalParkingOrder = naturalParkingOrder;
    }

    public Receipt park(Car car) {
        ParkingLot parkingLot = selectParkingLot();
        parkingLot.park(car);
        String validationNumber = "any vn";
        Receipt receipt = new Receipt(validationNumber, parkingLot.getId(), car);
        receipts.add(receipt);
        return receipt;
    }

    private ParkingLot selectParkingLot() {
        return parkingLots.get(naturalParkingOrder.getNextParkingLotId());
    }

    public Car takeBackCarWith(Receipt receipt) {
        if (!receipts.contains(receipt)) {
            throw new ReceiptInvalidException();
        }

        Car car = parkingLots
                .get(receipt.getParkingLotId())
                .takeBackCar(receipt.getCar());
        receipts.remove(receipt);
        return car;
    }
}
