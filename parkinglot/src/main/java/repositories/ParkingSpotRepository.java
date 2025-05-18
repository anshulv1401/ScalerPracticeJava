package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;

public class ParkingSpotRepository {
    private Map<Long, ParkingSpot> dataMap = new HashMap<>();

    public ParkingSpotRepository() {
        super();
        var parkingSpot = new ParkingSpot();
        parkingSpot.setId(1);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot.setVehicleType(VehicleType.SUV);
        parkingSpot.setSpotNumber(1);

        dataMap.put(parkingSpot.getId(), parkingSpot);
    }

    public Optional<ParkingSpot> findById(Long id) {

        if (dataMap.containsKey(id)) {
            return Optional.of(dataMap.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<ParkingSpot> getAllParkingSpot() {
        return dataMap.values().stream().toList();
    }

    public void save(ParkingSpot spot) {
        dataMap.put(spot.getId(), spot);
    }
}
