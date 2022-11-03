package com.example.fuel_que_mobileapp.models.user;

public class StationCardViewModel {
    private String fuel_station_name;
    private int image;

    public StationCardViewModel(String fuel_station_name, int image) {
        this.fuel_station_name = fuel_station_name;
        this.image = image;
    }

    public String getFuel_station_name() {
        return fuel_station_name;
    }

    public void setFuel_station_name(String fuel_station_name) {
        this.fuel_station_name = fuel_station_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
