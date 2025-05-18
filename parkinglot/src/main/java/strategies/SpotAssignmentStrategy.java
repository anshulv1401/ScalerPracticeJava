package strategies;

import models.Gate;
import models.ParkingSpot;
import models.enums.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
