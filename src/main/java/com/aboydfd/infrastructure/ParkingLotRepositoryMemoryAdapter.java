package com.aboydfd.infrastructure;

import com.aboydfd.domain.parkinglot.ParkingLot;
import com.aboydfd.domain.parkinglot.ParkingLotId;
import com.aboydfd.domain.parkinglot.ParkingLotRepository;

public class ParkingLotRepositoryMemoryAdapter
        extends RepositoryMemoryAdapter<ParkingLot, ParkingLotId>
        implements ParkingLotRepository {
}
