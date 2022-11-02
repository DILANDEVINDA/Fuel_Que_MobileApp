package com.example.fuel_que_mobileapp.models.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FuelStationAPI {

    @GET("backend/FuelStation/{id}")
    Call<FuelStationModel> getSpecificFuelStation(@Path("id") String id);

    @PUT("backend/FuelStation/{id}")
    Call<Void> updateSpecificFuelStation(@Path("id") String id,@Body FuelTypeModel fuelTypeUpdate);

}
