package com.example.fuel_que_mobileapp.models.user;

public class FuelStationModel {
    public String id;
    public String ownerId;
    public String name;
    public String location;
    public int fuelNinetytwo;
    public String fuelNinetytwoArrival;
    public String fuelNinetytwoFinishing;
    public int fuelNinetyFive;
    public String fuelNinetyFiveArrival;
    public String fuelNinetyFiveFinishing;
    public int autoDiesel;
    public String autoDieselArrival;
    public String autoDieselFinishing;
    public int superDiesel;
    public String superDieselArrival;
    public String superDieselFinising;

    public FuelStationModel(
    String OwnerId,
    String Name,String Location,
    int fuelNinetyTwo,
    String fuelNinetyTwoArrival,
    String fuelNinetytwoFinishing,
    int fuelNinetyFive,
    String fuelNinetyFiveArrival,
    String fuelNinetyFiveFinishing,
    int autoDiesel,
    String fuelAutoDieselArrival,
    String fuelAutoDieselFinishing,
    int superDiesel,
    String fuelSuperDieselArrival,
    String fuelSuperDieselFinishing)
    {
        this.ownerId = OwnerId;
        this.name = Name;
        this.location = Location;
        this.fuelNinetytwo = fuelNinetyTwo;
        this.fuelNinetytwoArrival = fuelNinetyTwoArrival;
        this.fuelNinetytwoFinishing = fuelNinetytwoFinishing;
        this.fuelNinetyFive = fuelNinetyFive;
        this.fuelNinetyFiveArrival = fuelNinetyFiveArrival;
        this.fuelNinetyFiveFinishing = fuelNinetyFiveFinishing;
        this.autoDiesel = autoDiesel;
        this.autoDieselArrival = fuelAutoDieselArrival;
        this.autoDieselFinishing = fuelAutoDieselFinishing;
        this.superDiesel = superDiesel;
        this.superDieselArrival = fuelSuperDieselArrival;
        this.superDieselFinising = fuelSuperDieselFinishing;
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

    public String getFuelNinetytwoArrival() {
        return fuelNinetytwoArrival;
    }

    public String getFuelNinetytwoFinishing() {
        return fuelNinetytwoFinishing;
    }

    public int getFuelNinetyFive() {
        return fuelNinetyFive;
    }

    public String getFuelNinetyFiveArrival() {
        return fuelNinetyFiveArrival;
    }

    public String getFuelNinetyFiveFinishing() {
        return fuelNinetyFiveFinishing;
    }

    public int getAutoDiesel() {
        return autoDiesel;
    }

    public String getAutoDieselArrival() {
        return autoDieselArrival;
    }

    public String getAutoDieselFinishing() {
        return autoDieselFinishing;
    }

    public int getSuperDiesel() {
        return superDiesel;
    }

    public String getSuperDieselArrival() {
        return superDieselArrival;
    }

    public String getSuperDieselFinising() {
        return superDieselFinising;
    }
}
