package models;

import java.util.Date;

import models.enums.TicketStatus;

public class Ticket extends BaseModel {
    private String tickerNumber;
    private Gate generatedAt;
    private Date entryTime;
    private Operator generatedBy;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private TicketStatus ticketStatus;

    public String getTickerNumber() {
        return tickerNumber;
    }

    public void setTickerNumber(String tickerNumber) {
        this.tickerNumber = tickerNumber;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

}
