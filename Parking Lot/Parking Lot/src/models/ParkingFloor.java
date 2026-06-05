package models;

import enums.ParkingFloorStatus;
import java.util.*;
public class ParkingFloor extends BaseModel{


    private int number;
    private List<ParkingSpot> spots;
    private ParkingFloorStatus status;



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public ParkingFloorStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingFloorStatus status) {
        this.status = status;
    }
}
