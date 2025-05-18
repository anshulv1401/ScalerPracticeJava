package repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import models.Vehicle;

public class VehicleRepository {
    private Map<String, Vehicle> dataMap = new HashMap<>();

    public Optional<Vehicle> findByVehicelNumber(String vehicleNumber) {

        if (dataMap.containsKey(vehicleNumber)) {
            return Optional.of(dataMap.get(vehicleNumber));
        } else {
            return Optional.empty();
        }
    }

    public void save(Vehicle vehicle) {
        dataMap.put(vehicle.getVehicleNumber(), vehicle);
    }

}
