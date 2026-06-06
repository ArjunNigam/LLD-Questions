package strategies;

import models.PricingPlan;
import models.Ticket;

public interface PricingStrategy {

    public double calculateAmount(Ticket ticket, PricingPlan pricingPlan);
}
