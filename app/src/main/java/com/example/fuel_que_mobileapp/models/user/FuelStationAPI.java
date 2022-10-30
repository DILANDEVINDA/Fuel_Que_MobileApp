package com.example.fuel_que_mobileapp.models.user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FuelStationAPI {

    @GET("backend/FuelStation/{fuelStationId}")
    Call<FuelStationModel> getSpecificFuelStation(@Path("fuelStationId") String fuelStationId);
}
