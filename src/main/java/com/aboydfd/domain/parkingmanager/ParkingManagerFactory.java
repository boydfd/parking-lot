package com.aboydfd.domain.parkingmanager;

import com.aboydfd.domain.parkingboy.ParkingBoy;
import com.aboydfd.domain.parkingboy.ParkingBoyConfigRepository;
import com.aboydfd.domain.parkingboy.ParkingBoyFactory;
import com.aboydfd.domain.parkinglot.ParkingLotRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParkingManagerFactory {
    public static ParkingManager create(ParkingManagerConfig parkingManagerConfig,
                                        ParkingBoyConfigRepository parkingBoyConfigRepository,
                                        ParkingLotRepository parkingLotRepository) {
        List<ParkingBoy> parkingBoys = parkingManagerConfig
                .getParkingBoys()
                .stream()
                .map(parkingBoyConfigRepository::findById)
                .map(it -> ParkingBoyFactory.create(it, parkingLotRepository))
                .collect(toList());
        return new ParkingManager(parkingBoys);
    }
}
