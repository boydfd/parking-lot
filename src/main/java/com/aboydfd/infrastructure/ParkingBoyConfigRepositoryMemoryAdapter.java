package com.aboydfd.infrastructure;

import com.aboydfd.domain.parkingboy.ParkingBoyConfig;
import com.aboydfd.domain.parkingboy.ParkingBoyConfigRepository;
import com.aboydfd.domain.parkingboy.ParkingBoyId;

public class ParkingBoyConfigRepositoryMemoryAdapter
        extends RepositoryMemoryAdapter<ParkingBoyConfig, ParkingBoyId>
        implements ParkingBoyConfigRepository{
}
