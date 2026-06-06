package services;

import enums.PricingStrategyType;
import exceptions.InvalidPricingPlanException;
import exceptions.NoParkingSpotAvailableException;
import models.Gate;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;

public interface TicketService {

    public Ticket generateTicket(ParkingLot parkingLot, Vehicle vehicle, Gate entryGate, PricingStrategyType pricingStrategyType) throws InvalidPricingPlanException, NoParkingSpotAvailableException;
}
