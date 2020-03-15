package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.Entity;
import com.aboydfd.domain.parkinglot.ParkingLotId;

import java.util.List;

public class ParkingBoyConfig implements Entity<ParkingBoyId> {
    private ParkingBoyId id;
    private List<ParkingLotId> parkingLotIds;
    private ParkingStrategyEnum parkingStrategyEnum;

    public ParkingBoyConfig(ParkingBoyId id, List<ParkingLotId> parkingLotIds,
                            ParkingStrategyEnum parkingStrategyEnum) {
        this.id = id;
        this.parkingLotIds = parkingLotIds;
        this.parkingStrategyEnum = parkingStrategyEnum;
    }

    @Override
    public ParkingBoyId getId() {
        return id;
    }

    public List<ParkingLotId> getParkingLotIds() {
        return parkingLotIds;
    }

    public ParkingStrategyEnum getParkingStrategy() {
        return parkingStrategyEnum;
    }
}
