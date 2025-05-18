package models;

import models.enums.GateStatus;
import models.enums.GateType;

public class Gate extends BaseModel {

    private int GateNumber;
    private int currentOperator;
    private GateType gateType;
    private GateStatus gateStatus;

    public int getGateNumber() {
        return GateNumber;
    }

    public void setGateNumber(int gateNumber) {
        GateNumber = gateNumber;
    }

    public int getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(int currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

}
