package com.example.fuel_que_mobileapp.models.user;

public class FuelStationModel {
    private String id;
    private String ownerId;
    private String name;
    private String location;
    private int fuelNinetytwo;
    private int fuelNinetytwoCarryingAmount;
    private String fuelNinetytwoArrivalTime;
    private String fuelNinetytwoArrivalDate;
    private String fuelNinetytwoFinishing;
    private int fuelNinetyFive;
    private int fuelNinetyFiveCarryingAmount;
    private String fuelNinetyFiveArrivalTime;
    private String fuelNinetyFiveArrivalDate;
    private String fuelNinetyFiveFinishing;
    private int autoDiesel;
    private int autoDieselCarryingAmount;
    private String autoDieselArrivalTime;
    private String autoDieselArrivalDate;
    private String autoDieselFinishing;
    private int superDiesel;
    private int superDieselCarryingAmount;
    private String superDieselArrivalTime;
    private String superDieselArrivalDate;
    private String superDieselFinishing;

    public FuelStationModel(String ownerId, String name, String location, int fuelNinetytwo, int fuelNinetyFive, int autoDiesel, int superDiesel) {
        this.ownerId = ownerId;
        this.name = name;
        this.location = location;
        this.fuelNinetytwo = fuelNinetytwo;
        this.fuelNinetytwoCarryingAmount = 0;
        this.fuelNinetytwoArrivalTime = "-";
        this.fuelNinetytwoArrivalDate = "-";
        this.fuelNinetytwoFinishing = "-";
        this.fuelNinetyFive = fuelNinetyFive;
        this.fuelNinetyFiveCarryingAmount = 0;
        this.fuelNinetyFiveArrivalTime = "-";
        this.fuelNinetyFiveArrivalDate = "-";
        this.fuelNinetyFiveFinishing = "-";
        this.autoDiesel = autoDiesel;
        this.autoDieselCarryingAmount = 0;
        this.autoDieselArrivalTime = "-";
        this.autoDieselArrivalDate = "-";
        this.autoDieselFinishing = "-";
        this.superDiesel = superDiesel;
        this.superDieselCarryingAmount = 0;
        this.superDieselArrivalTime = "-";
        this.superDieselArrivalDate = "-";
        this.superDieselFinishing = "-";
    }

    public FuelStationModel(String id, String ownerId, String name, String location, int fuelNinetytwo, int fuelNinetytwoCarryingAmount, String fuelNinetytwoArrivalTime, String fuelNinetytwoArrivalDate, String fuelNinetytwoFinishing, int fuelNinetyFive, int fuelNinetyFiveCarryingAmount, String fuelNinetyFiveArrivalTime, String fuelNinetyFiveArrivalDate, String fuelNinetyFiveFinishing, int autoDiesel, int autoDieselCarryingAmount, String autoDieselArrivalTime, String autoDieselArrivalDate, String autoDieselFinishing, int superDiesel, int superDieselCarryingAmount, String superDieselArrivalTime, String superDieselArrivalDate, String superDieselFinishing) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.location = location;
        this.fuelNinetytwo = fuelNinetytwo;
        this.fuelNinetytwoCarryingAmount = fuelNinetytwoCarryingAmount;
        this.fuelNinetytwoArrivalTime = fuelNinetytwoArrivalTime;
        this.fuelNinetytwoArrivalDate = fuelNinetytwoArrivalDate;
        this.fuelNinetytwoFinishing = fuelNinetytwoFinishing;
        this.fuelNinetyFive = fuelNinetyFive;
        this.fuelNinetyFiveCarryingAmount = fuelNinetyFiveCarryingAmount;
        this.fuelNinetyFiveArrivalTime = fuelNinetyFiveArrivalTime;
        this.fuelNinetyFiveArrivalDate = fuelNinetyFiveArrivalDate;
        this.fuelNinetyFiveFinishing = fuelNinetyFiveFinishing;
        this.autoDiesel = autoDiesel;
        this.autoDieselCarryingAmount = autoDieselCarryingAmount;
        this.autoDieselArrivalTime = autoDieselArrivalTime;
        this.autoDieselArrivalDate = autoDieselArrivalDate;
        this.autoDieselFinishing = autoDieselFinishing;
        this.superDiesel = superDiesel;
        this.superDieselCarryingAmount = superDieselCarryingAmount;
        this.superDieselArrivalTime = superDieselArrivalTime;
        this.superDieselArrivalDate = superDieselArrivalDate;
        this.superDieselFinishing = superDieselFinishing;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getFuelNinetytwo() {
        return fuelNinetytwo;
    }

    public int getFuelNinetytwoCarryingAmount() {
        return fuelNinetytwoCarryingAmount;
    }

    public String getFuelNinetytwoArrivalTime() {
        return fuelNinetytwoArrivalTime;
    }

    public String getFuelNinetytwoArrivalDate() {
        return fuelNinetytwoArrivalDate;
    }

    public String getFuelNinetytwoFinishing() {
        return fuelNinetytwoFinishing;
    }

    public int getFuelNinetyFive() {
        return fuelNinetyFive;
    }

    public int getFuelNinetyFiveCarryingAmount() {
        return fuelNinetyFiveCarryingAmount;
    }

    public String getFuelNinetyFiveArrivalTime() {
        return fuelNinetyFiveArrivalTime;
    }

    public String getFuelNinetyFiveArrivalDate() {
        return fuelNinetyFiveArrivalDate;
    }

    public String getFuelNinetyFiveFinishing() {
        return fuelNinetyFiveFinishing;
    }

    public int getAutoDiesel() {
        return autoDiesel;
    }

    public int getAutoDieselCarryingAmount() {
        return autoDieselCarryingAmount;
    }

    public String getAutoDieselArrivalTime() {
        return autoDieselArrivalTime;
    }

    public String getAutoDieselArrivalDate() {
        return autoDieselArrivalDate;
    }

    public String getAutoDieselFinishing() {
        return autoDieselFinishing;
    }

    public int getSuperDiesel() {
        return superDiesel;
    }

    public int getSuperDieselCarryingAmount() {
        return superDieselCarryingAmount;
    }

    public String getSuperDieselArrivalTime() {
        return superDieselArrivalTime;
    }

    public String getSuperDieselArrivalDate() {
        return superDieselArrivalDate;
    }

    public String getSuperDieselFinishing() {
        return superDieselFinishing;
    }
}
