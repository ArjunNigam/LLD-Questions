package strategies;

import enums.ParkingFloorStatus;
import enums.ParkingSpotStatus;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

import java.util.Optional;

public class FirstAvailableParkingSpotAllocationStrategy implements ParkingSpotAllocationStrategy{
    @Override
    public Optional<ParkingSpot> allocateParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {

        // Traverse through all the floors and in each floor all the spots. Return the first available parking spot found.
        ParkingSpot parkingSpot = null;
        boolean foundSpot = false;
        for(ParkingFloor floor : parkingLot.getFloors())
        {
            if(floor.getStatus() != ParkingFloorStatus.OPERATIONAL)
            {
                continue;
            }

            // Now traverse through all the parking spots in this floor.

            for(ParkingSpot spot : floor.getSpots())
            {
                if(spot.getStatus() != ParkingSpotStatus.AVAILABLE || !(spot.getSupportedVehicleTypes().contains(vehicle.getVehicleType())))
                {
                    continue;
                }

                // Coming till this line means we have a compatible spot
                parkingSpot = spot;
                foundSpot = true;
                break;
            }

            if(foundSpot) break;
        }

        return Optional.ofNullable(parkingSpot);
    }
}
