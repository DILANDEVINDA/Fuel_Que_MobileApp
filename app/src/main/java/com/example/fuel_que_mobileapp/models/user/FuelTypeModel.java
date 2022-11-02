package com.example.fuel_que_mobileapp.models.user;

public class FuelTypeModel {

    private String type;
    private String userID;
    private String fuelArrivalDate;
    private String fuelFinishing;
    private String fuelArrivalTime;
    private int carryingAmount;

    public FuelTypeModel(String type, String userID, String fuelArrivalDate, String fuelFinishing, String fuelArrivalTime, int carryingAmount) {
        this.type = type;
        this.userID = userID;
        this.fuelArrivalDate = fuelArrivalDate;
        this.fuelFinishing = fuelFinishing;
        this.fuelArrivalTime = fuelArrivalTime;
        this.carryingAmount = carryingAmount;
    }

    public String getType() {
        return type;
    }

    public String getUserID() {
        return userID;
    }

    public String getFuelArrivalDate() {
        return fuelArrivalDate;
    }

    public String getFuelFinishing() {
        return fuelFinishing;
    }

    public String getFuelArrivalTime() {
        return fuelArrivalTime;
    }

    public int getCarryingAmount() {
        return carryingAmount;
    }
}
