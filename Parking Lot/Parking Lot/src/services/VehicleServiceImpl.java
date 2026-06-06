package services;

import models.Vehicle;
import repositories.VehicleRepository;

import java.util.Optional;

public class VehicleServiceImpl implements VehicleService{

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle findOrCreateVehicle(Vehicle vehicle) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByNumber(vehicle.getNumber());
        if(optionalVehicle.isEmpty())
        {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setVehicleType(vehicle.getVehicleType());
            newVehicle.setNumber(vehicle.getNumber());
            vehicleRepository.save(newVehicle);
        }

        return vehicleRepository.getVehicleByNumber(vehicle.getNumber()).get();

    }
}
