package models;

import java.util.List;

import models.enums.ParkingLotStatus;
import models.enums.SpotAssignmentStrategyType;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> ParkingFloors;
    private ParkingLotStatus parkingLostStatus;
    private ParkingLotManager parkingLotManager;
    private String Address;
    private int capacity;
    private SpotAssignmentStrategyType spotAssignmentStrategy;

    public List<ParkingFloor> getParkingFloors() {
        return ParkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        ParkingFloors = parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLostStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLostStatus) {
        this.parkingLostStatus = parkingLostStatus;
    }

    public ParkingLotManager getParkingLotManager() {
        return parkingLotManager;
    }

    public void setParkingLotManager(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategy() {
        return spotAssignmentStrategy;
    }

    public void setSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategy) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

}