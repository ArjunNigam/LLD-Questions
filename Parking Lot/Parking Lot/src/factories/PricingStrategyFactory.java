package factories;

import enums.PricingStrategyType;
import strategies.FestivalPricingStrategy;
import strategies.PricingStrategy;
import strategies.SlabBasedPricingStrategy;

public class PricingStrategyFactory {

    public static PricingStrategy getStrategy(PricingStrategyType pricingStrategyType)
    {
        switch (pricingStrategyType)
        {
            case WEEKDAY :

            case WEEKEND :
                return new SlabBasedPricingStrategy();



            case FESTIVAL :
                return new FestivalPricingStrategy();

            default:
                throw new RuntimeException("Invalid Pricing Strategy");
        }
    }
}
