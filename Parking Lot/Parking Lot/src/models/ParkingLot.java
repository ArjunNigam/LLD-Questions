package models;
import enums.ParkingLotStatus;

import java.util.*;
public class ParkingLot extends BaseModel{


    private String address;
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private ParkingLotStatus status;



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }
}
