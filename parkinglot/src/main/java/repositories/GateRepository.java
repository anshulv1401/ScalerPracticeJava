package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.Gate;
import models.enums.GateStatus;
import models.enums.GateType;

public class GateRepository {
    private Map<Long, Gate> dataMap = new HashMap<>();

    public GateRepository() {

        var gate = new Gate();
        gate.setId(1);
        gate.setGateNumber(1);
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(GateType.ENTRY);

        dataMap.put(gate.getId(), gate);
    }

    public Optional<Gate> findById(Long id) {

        if (dataMap.containsKey(id)) {
            return Optional.of(dataMap.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Gate> getAllGates() {
        return dataMap.values().stream().toList();
    }
}
