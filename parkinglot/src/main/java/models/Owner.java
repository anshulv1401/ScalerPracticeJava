package models;

import models.enums.VehicleType;

public class Owner extends BaseModel {
    private String name;
    private String address;
    private VehicleType phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public VehicleType getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(VehicleType phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
