package com.aboydfd.domain.parkingboy;

import com.aboydfd.domain.parkinglot.ParkingLotId;

public interface ParkingStrategy {
    ParkingLotId getNextParkingLotId();
}
