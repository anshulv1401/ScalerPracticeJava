package dtos;

import models.enums.VehicleType;

public class IssueTickerRequestDto {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehiceleOwnerName;
    private Long gateId;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehiceleOwnerName() {
        return vehiceleOwnerName;
    }

    public void setVehiceleOwnerName(String vehiceleOwnerName) {
        this.vehiceleOwnerName = vehiceleOwnerName;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

}
