package models;

import enums.PricingStrategyType;
import enums.VehicleType;
import strategies.PricingStrategy;

public class PricingPlan extends BaseModel{

    private PricingStrategyType pricingStrategyType;

    private VehicleType vehicleType;

    private double firstTwoHoursRate, nextTwoHoursRate, afterFourHoursRate;

    public double getFirstTwoHoursRate() {
        return firstTwoHoursRate;
    }

    public void setFirstTwoHoursRate(double firstTwoHoursRate) {
        this.firstTwoHoursRate = firstTwoHoursRate;
    }

    public double getNextTwoHoursRate() {
        return nextTwoHoursRate;
    }

    public void setNextTwoHoursRate(double nextTwoHoursRate) {
        this.nextTwoHoursRate = nextTwoHoursRate;
    }

    public double getAfterFourHoursRate() {
        return afterFourHoursRate;
    }

    public void setAfterFourHoursRate(double afterFourHoursRate) {
        this.afterFourHoursRate = afterFourHoursRate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public PricingStrategyType getPricingStrategyType() {
        return pricingStrategyType;
    }

    public void setPricingStrategyType(PricingStrategyType pricingStrategyType) {
        this.pricingStrategyType = pricingStrategyType;
    }
}
