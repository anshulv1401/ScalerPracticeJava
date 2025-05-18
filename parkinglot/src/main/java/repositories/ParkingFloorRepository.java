package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.Gate;
import models.ParkingFloor;
import models.ParkingSpot;

public class ParkingFloorRepository {
    private Map<Long, ParkingFloor> dataMap = new HashMap<>();

    public ParkingFloorRepository(List<ParkingSpot> parkingSpots, List<Gate> gates) {
        super();

        var parkingFloor = new ParkingFloor();

        parkingFloor.setId(1);
        parkingFloor.setFloorNumber(1);
        parkingFloor.setParkingSpots(parkingSpots);
        parkingFloor.setGates(gates);

        dataMap.put(parkingFloor.getId(), parkingFloor);
    }

    public Optional<ParkingFloor> findById(Long id) {

        if (dataMap.containsKey(id)) {
            return Optional.of(dataMap.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<ParkingFloor> getAllParkingFloors() {
        return dataMap.values().stream().toList();
    }

    public void save(ParkingFloor spot) {
        dataMap.put(spot.getId(), spot);
    }
}
