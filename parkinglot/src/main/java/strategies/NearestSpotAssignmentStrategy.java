package strategies;

import models.Gate;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;
import repositories.ParkingSpotRepository;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy {

    ParkingSpotRepository parkingSpotRepository;

    public NearestSpotAssignmentStrategy(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        var listOfSpots = parkingSpotRepository.getAllParkingSpot();

        for (ParkingSpot parkingSpot : listOfSpots) {
            if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE)
                return parkingSpot;
        }

        return null;
    }
}
