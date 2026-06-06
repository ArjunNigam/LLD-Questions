package services;

import models.Vehicle;

import java.util.Optional;

public interface VehicleService {

    public Vehicle findOrCreateVehicle(Vehicle vehicle);
}
