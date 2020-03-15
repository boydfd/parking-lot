package com.aboydfd.domain;

import com.aboydfd.domain.parkingboy.ParkingBoyConfigRepository;
import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotRepository;
import com.aboydfd.domain.parkingmanager.*;

public class ParkingLotFindingService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingBoyConfigRepository parkingBoyConfigRepository;
    private final ParkingManagerConfigRepository parkingManagerConfigRepository;

    public ParkingLotFindingService(ParkingLotRepository parkingLotRepository,
                                    ParkingBoyConfigRepository parkingBoyConfigRepository,
                                    ParkingManagerConfigRepository parkingManagerConfigRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingBoyConfigRepository = parkingBoyConfigRepository;
        this.parkingManagerConfigRepository = parkingManagerConfigRepository;
    }

    public ParkingLot findAvailableParkingLotInParkingManager(ParkingManagerId id) {
        ParkingManagerConfig parkingManagerConfig = parkingManagerConfigRepository.findById(id);
        ParkingManager parkingManager = ParkingManagerFactory.create(parkingManagerConfig,
                parkingBoyConfigRepository,
                parkingLotRepository
                );
        return parkingManager.findAvailableParkingBoy().get().selectParkingLot();
    }
}
