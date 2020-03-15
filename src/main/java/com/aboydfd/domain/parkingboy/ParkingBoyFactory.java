package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotId;
import com.aboydfd.domain.parkinglot.ParkingLotRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParkingBoyFactory {
    public static ParkingBoy create(ParkingBoyConfig parkingBoyConfig, ParkingLotRepository parkingLotRepository) {
        List<ParkingLotId> parkingLotsIds = parkingBoyConfig
                .getParkingLotIds();
        List<ParkingLot> parkingLots = parkingLotsIds
                .stream()
                .map(parkingLotRepository::findById)
                .collect(toList());
        NaturalParkingStrategy parkingStrategy = getParkingStrategy(parkingBoyConfig, parkingLotsIds);
        return new ParkingBoy(parkingLots, parkingStrategy);
    }

    private static NaturalParkingStrategy getParkingStrategy(ParkingBoyConfig parkingBoyConfig,
                                                             List<ParkingLotId> parkingLotsIds) {
        switch (parkingBoyConfig.getParkingStrategy()) {
            case NATURAL:
            default:
                return new NaturalParkingStrategy(parkingLotsIds, 0);

        }
    }
}
