package models;

import enums.ParkingSpotStatus;
import enums.VehicleType;
import java.util.*;

public class ParkingSpot extends BaseModel{


    private int number;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingSpotStatus status;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }
}
