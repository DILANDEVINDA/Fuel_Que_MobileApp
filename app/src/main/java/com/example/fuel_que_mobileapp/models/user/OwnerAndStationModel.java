package com.example.fuel_que_mobileapp.models.user;

public class OwnerAndStationModel {

    private UserModel User;
    private String StationName;
    private String Location;
    private int FuelNinetytwo;
    private int FuelNinetyFive;
    private int AutoDiesel;
    private int superDiesel;

    public OwnerAndStationModel(UserModel user, String stationName, String location, int fuelNinetytwo, int fuelNinetyFive, int autoDiesel, int superDiesel) {
        User = user;
        StationName = stationName;
        Location = location;
        FuelNinetytwo = fuelNinetytwo;
        FuelNinetyFive = fuelNinetyFive;
        AutoDiesel = autoDiesel;
        this.superDiesel = superDiesel;
    }

    public UserModel getUser() {
        return User;
    }

    public String getStationName() {
        return StationName;
    }

    public String getLocation() {
        return Location;
    }

    public int getFuelNinetytwo() {
        return FuelNinetytwo;
    }

    public int getFuelNinetyFive() {
        return FuelNinetyFive;
    }

    public int getAutoDiesel() {
        return AutoDiesel;
    }

    public int getSuperDiesel() {
        return superDiesel;
    }
}
