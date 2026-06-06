package repositories;

import enums.PricingStrategyType;
import enums.VehicleType;
import models.PricingPlan;

import java.util.Optional;

public interface PricingPlanRepository {

    public void save(PricingPlan plan);

    public Optional<PricingPlan> findByVehicleTypeAndStrategyType(VehicleType vehicleType, PricingStrategyType pricingStrategyType);
}
