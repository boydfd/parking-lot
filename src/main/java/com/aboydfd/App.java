package com.aboydfd;

import com.aboydfd.domain.parkingboy.NaturalParkingOrder;
import com.aboydfd.domain.parkingboy.ParkingBoy;
import com.aboydfd.domain.parkinglot.Car;
import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotId;
import com.aboydfd.domain.parkinglot.Ticket;

import java.util.stream.IntStream;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class App {

    public static void main(String[] args) {
        System.out.println("There are two parking lot: ");
        ParkingLotId parkingLotId1 = new ParkingLotId("p1");
        ParkingLot parkingLot = new ParkingLot(10, parkingLotId1);
        ParkingLotId parkingLotId2 = new ParkingLotId("p2");
        ParkingLot parkingLot2 = new ParkingLot(10, parkingLotId2);
        NaturalParkingOrder naturalParkingOrder =
                new NaturalParkingOrder(newArrayList(parkingLotId1, parkingLotId2), 1);
        ParkingBoy parkingBoy =
                new ParkingBoy(newArrayList(parkingLot, parkingLot2), naturalParkingOrder);

        IntStream.range(1, 21)
                .boxed()
                .map(i -> {
                    String plateNumber = String.valueOf(i);
                    Car car = new Car(plateNumber);
                    Ticket ticket = parkingBoy.park(car);
                    System.out.println(String.format("park car: %s to %s", plateNumber, ticket.getParkingLotId()));
                    return ticket;
                })
                .collect(toList())
                .forEach(ticket -> {
                    Car car = parkingBoy.takeBackCarWith(ticket);
                    System.out.println(String.format("take back car: %s", car));
                });

    }
}
