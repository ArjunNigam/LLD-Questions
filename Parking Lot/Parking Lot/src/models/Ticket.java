package models;

import enums.ParkingSpotStatus;
import enums.TicketStatus;

import java.util.*;
import java.util.Date;

public class Ticket extends BaseModel{

    private Vehicle vehicle;
    private ParkingSpot assignedParkingSpot;
    private Date entryTime;
    private Gate entryGate;
    private TicketStatus status;
    private PricingPlan pricingPlan;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getAssignedParkingSpot() {
        return assignedParkingSpot;
    }

    public void setAssignedParkingSpot(ParkingSpot assignedParkingSpot) {
        this.assignedParkingSpot = assignedParkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public PricingPlan getPricingPlan() {
        return pricingPlan;
    }

    public void setPricingPlan(PricingPlan pricingPlan) {
        this.pricingPlan = pricingPlan;
    }
}
