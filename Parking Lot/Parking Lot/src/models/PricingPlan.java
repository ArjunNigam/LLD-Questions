package models;

import enums.PricingStrategyType;

public class PricingPlan extends BaseModel{

    private PricingStrategy pricingStrategy;

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
