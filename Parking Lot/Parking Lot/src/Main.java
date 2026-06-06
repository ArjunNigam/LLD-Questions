import enums.*;
import models.*;
import repositories.*;
import services.*;
import strategies.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // -----------------------------
        // Repositories
        // -----------------------------

        VehicleRepository vehicleRepository =
                new VehicleRepositoryImpl();

        TicketRepository ticketRepository =
                new TicketRepositoryImpl();

        PricingPlanRepository pricingPlanRepository =
                new PricingPlanRepositoryImpl();

        BillRepository billRepository =
                new BillRepositoryImpl();

        PaymentRepository paymentRepository =
                new PaymentRepositoryImpl();

        // -----------------------------
        // Services
        // -----------------------------

        VehicleService vehicleService =
                new VehicleServiceImpl(vehicleRepository);

        ParkingSpotAllocationStrategy parkingStrategy =
                new FirstAvailableParkingSpotAllocationStrategy();

        TicketService ticketService =
                new TicketServiceImpl(
                        vehicleService,
                        ticketRepository,
                        pricingPlanRepository,
                        parkingStrategy);

        BillService billService =
                new BillServiceImpl(
                        billRepository);

        PaymentService paymentService =
                new PaymentServiceImpl(
                        paymentRepository);

        // -----------------------------
        // Pricing Plans
        // -----------------------------

        PricingPlan bikeWeekendPlan =
                new PricingPlan();

        bikeWeekendPlan.setVehicleType(
                VehicleType.TWO_WHEELER);

        bikeWeekendPlan.setPricingStrategyType(
                PricingStrategyType.WEEKEND);

        bikeWeekendPlan.setFirstTwoHoursRate(20);
        bikeWeekendPlan.setNextTwoHoursRate(30);
        bikeWeekendPlan.setAfterFourHoursRate(40);

        pricingPlanRepository.save(
                bikeWeekendPlan);

        PricingPlan carWeekendPlan =
                new PricingPlan();

        carWeekendPlan.setVehicleType(
                VehicleType.FOUR_WHEELER);

        carWeekendPlan.setPricingStrategyType(
                PricingStrategyType.WEEKEND);

        carWeekendPlan.setFirstTwoHoursRate(30);
        carWeekendPlan.setNextTwoHoursRate(40);
        carWeekendPlan.setAfterFourHoursRate(50);

        pricingPlanRepository.save(
                carWeekendPlan);

        // -----------------------------
        // Create Parking Lot
        // -----------------------------

        ParkingSpot bikeSpot = new ParkingSpot();
        bikeSpot.setNumber(1);
        bikeSpot.setStatus(
                ParkingSpotStatus.AVAILABLE);
        bikeSpot.setSupportedVehicleTypes(
                List.of(
                        VehicleType.TWO_WHEELER));

        ParkingSpot carSpot = new ParkingSpot();
        carSpot.setNumber(2);
        carSpot.setStatus(
                ParkingSpotStatus.AVAILABLE);
        carSpot.setSupportedVehicleTypes(
                List.of(
                        VehicleType.FOUR_WHEELER));

        ParkingFloor floor = new ParkingFloor();
        floor.setNumber(1);
        floor.setStatus(
                ParkingFloorStatus.OPERATIONAL);
        floor.setSpots(
                Arrays.asList(
                        bikeSpot,
                        carSpot));

        Gate entryGate = new Gate();
        entryGate.setNumber(1);
        entryGate.setGateType(
                GateType.ENTRY);

        Gate exitGate = new Gate();
        exitGate.setNumber(2);
        exitGate.setGateType(
                GateType.EXIT);

        ParkingLot parkingLot =
                new ParkingLot();

        parkingLot.setAddress(
                "Whitefield");

        parkingLot.setStatus(
                ParkingLotStatus.OPERATIONAL);

        parkingLot.setFloors(
                List.of(floor));

        parkingLot.setGates(
                Arrays.asList(
                        entryGate,
                        exitGate));

        // -----------------------------
        // Vehicle Entry
        // -----------------------------

        Vehicle bike = new Vehicle();

        bike.setNumber(
                "KA01AB1234");

        bike.setVehicleType(
                VehicleType.TWO_WHEELER);

        Ticket ticket =
                ticketService.generateTicket(
                        parkingLot,
                        bike,
                        entryGate,
                        PricingStrategyType.WEEKEND);

        System.out.println(
                "Ticket Generated");

        System.out.println(
                ticket.getStatus());

        System.out.println(
                ticket.getAssignedParkingSpot()
                        .getStatus());

        // -----------------------------
        // Simulate 5 hours parking
        // -----------------------------

        Calendar calendar =
                Calendar.getInstance();

        calendar.add(
                Calendar.HOUR,
                -5);

        ticket.setEntryTime(
                calendar.getTime());

        // -----------------------------
        // Generate Bill
        // -----------------------------

        Bill bill =
                billService.generateBill(
                        parkingLot,
                        ticket,
                        exitGate);

        System.out.println(
                "Bill Amount = "
                        + bill.getAmount());

        System.out.println(
                "Bill Status = "
                        + bill.getBillStatus());

        // -----------------------------
        // Partial Payment
        // -----------------------------

        paymentService.makePayment(
                bill,
                bill.getAmount() / 2,
                PaymentMode.CASH);

        System.out.println(
                "After Partial Payment");

        System.out.println(
                bill.getBillStatus());

        System.out.println(
                ticket.getStatus());

        // -----------------------------
        // Remaining Payment
        // -----------------------------

        paymentService.makePayment(
                bill,
                bill.getAmount(),
                PaymentMode.UPI);

        System.out.println(
                "After Full Payment");

        System.out.println(
                bill.getBillStatus());

        System.out.println(
                ticket.getStatus());

        System.out.println(
                ticket.getAssignedParkingSpot()
                        .getStatus());
    }
}