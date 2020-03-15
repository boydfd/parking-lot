package com.aboydfd.infrastructure;

import com.aboydfd.domain.parkingmanager.ParkingManagerConfig;
import com.aboydfd.domain.parkingmanager.ParkingManagerConfigRepository;
import com.aboydfd.domain.parkingmanager.ParkingManagerId;

public class ParkingManagerConfigRepositoryMemoryAdapter
        extends RepositoryMemoryAdapter<ParkingManagerConfig, ParkingManagerId>
        implements ParkingManagerConfigRepository {
}
