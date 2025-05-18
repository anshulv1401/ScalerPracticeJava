package repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import models.Gate;

public class GateRepository {
    private Map<Long, Gate> dataMap = new HashMap<>();

    public Optional<Gate> findById(Long id) {

        if (dataMap.containsKey(id)) {
            return Optional.of(dataMap.get(id));
        } else {
            return Optional.empty();
        }
    }
}
