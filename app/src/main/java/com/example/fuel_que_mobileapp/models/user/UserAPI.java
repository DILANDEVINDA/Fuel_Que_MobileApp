package com.example.fuel_que_mobileapp.models.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserAPI {

    @GET()
    Call<UserModel> getSpecificUser();

    @POST("backend/User/createOwnerAndStation")
    Call<Void> createUser(@Body UserModel user);
}
