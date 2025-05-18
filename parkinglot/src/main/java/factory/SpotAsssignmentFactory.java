package factory;

import models.enums.SpotAssignmentStrategyType;
import repositories.ParkingSpotRepository;
import strategies.CheapestSpotAssignmentStrategy;
import strategies.NearestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class SpotAsssignmentFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType type,
            ParkingSpotRepository parkingSpotRepository) {
        if (type.equals(SpotAssignmentStrategyType.NEAREST))
            return new NearestSpotAssignmentStrategy(parkingSpotRepository);
        else if (type.equals(SpotAssignmentStrategyType.CHEAPEST))
            return new CheapestSpotAssignmentStrategy();

        return null;
    }
}
