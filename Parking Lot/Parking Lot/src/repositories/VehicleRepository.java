package repositories;

import models.Vehicle;

import java.util.Optional;

public interface VehicleRepository {

    public void save(Vehicle vehicle);
    public Optional<Vehicle> getVehicleById(long id);
    public Optional<Vehicle> getVehicleByNumber(String Number);
}
