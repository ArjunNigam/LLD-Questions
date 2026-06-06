package strategies;

import enums.VehicleType;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

import java.util.Optional;

public interface ParkingSpotAllocationStrategy {

    Optional<ParkingSpot> allocateParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
