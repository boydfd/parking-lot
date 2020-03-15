package com.aboydfd.domain;

import com.aboydfd.domain.parkingboy.ParkingBoyConfig;
import com.aboydfd.domain.parkingboy.ParkingBoyConfigRepository;
import com.aboydfd.domain.parkingboy.ParkingBoyId;
import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotId;
import com.aboydfd.domain.parkinglot.ParkingLotRepository;
import com.aboydfd.domain.parkingmanager.ParkingManagerConfig;
import com.aboydfd.domain.parkingmanager.ParkingManagerConfigRepository;
import com.aboydfd.domain.parkingmanager.ParkingManagerId;
import com.aboydfd.infrastructure.ParkingBoyConfigRepositoryMemoryAdapter;
import com.aboydfd.infrastructure.ParkingLotRepositoryMemoryAdapter;
import com.aboydfd.infrastructure.ParkingManagerConfigRepositoryMemoryAdapter;
import org.junit.jupiter.api.Test;

import static com.aboydfd.domain.parkingboy.ParkingStrategyEnum.NATURAL;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotFindingServiceTest {
    @Test
    void parking_lot_is_available___find_available_parking_lot___parking_lot_returned() {
        ParkingLot parkingLot = new ParkingLot(10, new ParkingLotId("pli 1"));
        ParkingLotRepository parkingLotRepository = new ParkingLotRepositoryMemoryAdapter();
        parkingLotRepository.save(parkingLot);

        ParkingBoyConfigRepository parkingBoyConfigRepository = new ParkingBoyConfigRepositoryMemoryAdapter();
        ParkingBoyConfig parkingBoyConfig = new ParkingBoyConfig(new ParkingBoyId("pbi 1"),
                newArrayList(parkingLot.getId()), NATURAL);
        parkingBoyConfigRepository.save(parkingBoyConfig);

        ParkingManagerConfigRepository parkingManagerConfigRepository =
                new ParkingManagerConfigRepositoryMemoryAdapter();
        ParkingManagerConfig parkingManagerConfig = new ParkingManagerConfig(new ParkingManagerId("pbi 1"),
                newArrayList(parkingBoyConfig.getId()));
        parkingManagerConfigRepository.save(parkingManagerConfig);

        ParkingLotFindingService parkingLotFindingService = new ParkingLotFindingService(parkingLotRepository, parkingBoyConfigRepository,
                parkingManagerConfigRepository);

        ParkingLot availableParkingLot = parkingLotFindingService
                .findAvailableParkingLotInParkingManager(parkingManagerConfig.getId());
        assertEquals(parkingLot.getId(), availableParkingLot.getId());

    }
}
