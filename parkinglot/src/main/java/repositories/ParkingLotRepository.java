package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.ParkingFloor;
import models.ParkingLot;
import models.enums.SpotAssignmentStrategyType;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> dataMap = new HashMap<>();

    public ParkingLotRepository(List<ParkingFloor> parkingFloors) {
        super();
        var parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setAddress("address");
        parkingLot.setCapacity(5);
        parkingLot.setParkingFloors(parkingFloors);
        parkingLot.setSpotAssignmentStrategy(SpotAssignmentStrategyType.NEAREST);

        dataMap.put(parkingLot.getId(), parkingLot);
    }

    public Optional<ParkingLot> findById(Long id) {

        if (dataMap.containsKey(id)) {
            return Optional.of(dataMap.get(id));
        } else {
            return Optional.empty();
        }
    }

}
