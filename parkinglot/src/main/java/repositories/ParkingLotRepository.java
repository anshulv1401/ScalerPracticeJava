package repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import models.ParkingLot;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> dataMap = new HashMap<>();

    public Optional<ParkingLot> findById(Long id) {

        if (dataMap.containsKey(id)) {
            return Optional.of(dataMap.get(id));
        } else {
            return Optional.empty();
        }
    }

}
