package repositories;

import enums.PricingStrategyType;
import enums.VehicleType;
import models.PricingPlan;
import java.util.*;
import java.util.Optional;

public class PricingPlanRepositoryImpl implements PricingPlanRepository{

    private Map<String, PricingPlan> map;

    public PricingPlanRepositoryImpl()
    {
        map = new HashMap<>();
    }

    @Override
    public void save(PricingPlan plan) {

        map.put(buildKey(plan.getVehicleType(), plan.getPricingStrategyType()), plan);

    }

    @Override
    public Optional<PricingPlan> findByVehicleTypeAndStrategyType(VehicleType vehicleType, PricingStrategyType pricingStrategyType) {
        String key = buildKey(vehicleType, pricingStrategyType);
        return Optional.ofNullable(map.get(key));
    }

    private String buildKey(VehicleType vehicleType, PricingStrategyType strategyType)
    {
        return vehicleType.name() + "_" + strategyType.name();
    }

}
