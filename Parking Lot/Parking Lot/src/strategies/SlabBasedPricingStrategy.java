package strategies;

import models.PricingPlan;
import models.Ticket;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class SlabBasedPricingStrategy implements PricingStrategy{

    @Override
    public double calculateAmount(Ticket ticket, PricingPlan pricingPlan) {
        Instant entryTime = ticket.getEntryTime().toInstant();
        Instant exitTime = Instant.now();

        long hours = Duration.between(entryTime, exitTime).toHours();

        if (hours == 0)
        {
            hours = 1;
        }

        double amount ;

        if (hours <= 2)
        {
            amount = hours * pricingPlan.getFirstTwoHoursRate();
        }
        else if(hours <= 4)
        {
            amount = (2 * pricingPlan.getFirstTwoHoursRate() + (hours - 2) * pricingPlan.getNextTwoHoursRate());
        }
        else {
            amount = (2 * pricingPlan.getFirstTwoHoursRate() + 2 * pricingPlan.getNextTwoHoursRate() + (hours - 4) * pricingPlan.getAfterFourHoursRate());
        }

        return amount;
    }
}
