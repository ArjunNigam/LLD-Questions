package services;

import enums.ParkingSpotStatus;
import enums.PricingStrategyType;
import enums.TicketStatus;
import exceptions.InvalidPricingPlanException;
import exceptions.NoParkingSpotAvailableException;
import models.*;
import repositories.PricingPlanRepository;
import repositories.TicketRepository;
import strategies.ParkingSpotAllocationStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketServiceImpl implements TicketService{

    private VehicleService vehicleService;
    private TicketRepository ticketRepository;
    private PricingPlanRepository pricingPlanRepository;
    private ParkingSpotAllocationStrategy parkingSpotAllocationStrategy;

    public TicketServiceImpl(VehicleService vehicleService, TicketRepository ticketRepository, PricingPlanRepository pricingPlanRepository, ParkingSpotAllocationStrategy parkingSpotAllocationStrategy)
    {
        this.vehicleService = vehicleService;
        this.ticketRepository = ticketRepository;
        this.pricingPlanRepository = pricingPlanRepository;
        this.parkingSpotAllocationStrategy = parkingSpotAllocationStrategy;
    }

    @Override
    public Ticket generateTicket(ParkingLot parkingLot, Vehicle vehicle, Gate entryGate, PricingStrategyType pricingStrategyType) throws InvalidPricingPlanException, NoParkingSpotAvailableException {

        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        Vehicle savedVehicle = vehicleService.findOrCreateVehicle(vehicle);
        ticket.setVehicle(savedVehicle);
        Optional<PricingPlan> optionalPricingPlan = pricingPlanRepository.findByVehicleTypeAndStrategyType(savedVehicle.getVehicleType(), pricingStrategyType);
        if(optionalPricingPlan.isEmpty())
        {
            throw new InvalidPricingPlanException("No such pricingStrategy exists for such Vehicle");
        }
        PricingPlan pricingPlan = optionalPricingPlan.get();
        ticket.setPricingPlan(pricingPlan);
        ticket.setEntryTime(new Date());
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotAllocationStrategy.allocateParkingSpot(parkingLot, savedVehicle);
        if(optionalParkingSpot.isEmpty())
        {
            throw new NoParkingSpotAvailableException("No parking spot is available for your vehicleType");
        }
        ParkingSpot parkingSpot = optionalParkingSpot.get();
        parkingSpot.setStatus(ParkingSpotStatus.OCCUPIED);
        ticket.setAssignedParkingSpot(parkingSpot);
        ticket.setStatus(TicketStatus.ACTIVE);
        ticketRepository.save(ticket);

        return ticket;

    }
}
