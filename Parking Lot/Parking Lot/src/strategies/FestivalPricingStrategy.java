package strategies;

import models.PricingPlan;
import models.Ticket;

public class FestivalPricingStrategy implements PricingStrategy{

    private static final double FESTIVE_SURCHARGE = 1.5;
    private final SlabBasedPricingStrategy slabBasedPricingStrategy = new SlabBasedPricingStrategy();
    @Override
    public double calculateAmount(Ticket ticket, PricingPlan pricingPlan) {

        double baseAmount = slabBasedPricingStrategy.calculateAmount(ticket, pricingPlan);
        return baseAmount * FESTIVE_SURCHARGE;

    }
}
