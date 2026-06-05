package repositories;

import models.Vehicle;
import java.util.*;
import java.util.Optional;

public class VehicleRepositoryImpl implements VehicleRepository {
    private Map<Long, Vehicle> vehicleIdMap;
    private Map<String, Vehicle> vehicleNumberMap;
    private static long vehicleId;

    public VehicleRepositoryImpl() {
        vehicleIdMap = new HashMap<>();
        vehicleNumberMap = new HashMap<>();
        vehicleId = 0;
    }


    @Override
    public void save(Vehicle vehicle) {
        if(vehicle.getId() == 0)
        {
            vehicle.setId(++vehicleId);
        }
        vehicleIdMap.put(vehicle.getId(), vehicle);
        vehicleNumberMap.put(vehicle.getNumber(), vehicle);

    }

    @Override
    public Optional<Vehicle> getVehicleById(long id) {
        return Optional.ofNullable(vehicleIdMap.get(id));
    }

    @Override
    public Optional<Vehicle> getVehicleByNumber(String Number) {
        return Optional.ofNullable(vehicleNumberMap.get(Number));
    }
}
