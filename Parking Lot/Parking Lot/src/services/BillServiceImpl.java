package services;

import enums.BillStatus;
import enums.PricingStrategyType;
import factories.PricingStrategyFactory;
import models.*;
import repositories.BillRepository;
import strategies.PricingStrategy;

import java.util.ArrayList;
import java.util.Date;

public class BillServiceImpl implements BillService {

    private BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository)
    {
        this.billRepository = billRepository;
    }

    @Override
    public Bill generateBill(ParkingLot parkingLot, Ticket ticket, Gate exitGate) {
        /*
        To generate the Bill, we need the following ->
        1. private Ticket ticket;
        2. private Date exitTime;
        3. private Gate exitGate;
        4. private double amount;
        5. private BillStatus billStatus;
        6. private List<Payment> payments;

        /*



         /*

        Step 1 - Calculate Amount.
            a. Get the pricingPlan from the ticket.
            b. Using the PricingPlan, get the PricingStrategyType
            c. Use the Factory to get PricingStrategy from PricingStrategyType
            d. Calculate amount using the PricingStrategy
         */

        PricingPlan pricingPlan = ticket.getPricingPlan();
        PricingStrategyType pricingStrategyType = pricingPlan.getPricingStrategyType();
        PricingStrategy pricingStrategy = PricingStrategyFactory.getStrategy(pricingStrategyType);
        double amount = pricingStrategy.calculateAmount(ticket, pricingPlan);

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitGate(exitGate);
        bill.setExitTime(new Date());
        bill.setPayments(new ArrayList<>());
        bill.setBillStatus(BillStatus.PENDING);
        billRepository.save(bill);
        return bill;



    }
}
