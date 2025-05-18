package factory;

import models.enums.SpotAssignmentStrategyType;
import strategies.CheapestSpotAssignmentStrategy;
import strategies.NearestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class SpotAsssignmentFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type) {
        if (type.equals(SpotAssignmentStrategyType.NEAREST))
            return new NearestSpotAssignmentStrategy();
        else if (type.equals(SpotAssignmentStrategyType.CHEAPEST))
            return new CheapestSpotAssignmentStrategy();

        return null;
    }
}
