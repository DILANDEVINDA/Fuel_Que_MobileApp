package com.example.fuel_que_mobileapp.models.user;

public class FuelStationModel {
    public String Id;
    public String OwnerId;
    public String Name;
    public String Location;
    public int FuelNinetytwo;
    public String FuelNinetytwoArrival;
    public String FuelNinetytwoFinishing;
    public int FuelNinetyFive;
    public String FuelNinetyFiveArrival;
    public String FuelNinetyFiveFinishing;
    public int AutoDiesel;
    public String AutoDieselArrival;
    public String AutoDieselFinishing;
    public int SuperDiesel;
    public String SuperDieselArrival;
    public String SuperDieselFinising;

    public FuelStationModel(String OwnerId,String Name,String Location, int fuelNinetyTwo,int fuelNinetyFive, int autoDiesel, int superDiesel)
    {
        this.OwnerId = OwnerId;
        this.Name = Name;
        this.Location = Location;
        FuelNinetytwo = fuelNinetyTwo;
        FuelNinetytwoArrival = "-";
        FuelNinetytwoFinishing = "-";
        FuelNinetyFive = fuelNinetyFive;
        FuelNinetyFiveArrival = "-";
        FuelNinetyFiveFinishing = "-";
        AutoDiesel = autoDiesel;
        AutoDieselArrival = "-";
        AutoDieselFinishing = "-";
        SuperDiesel = superDiesel;
        SuperDieselArrival = "-";
        SuperDieselFinising = "-";
    }
}
