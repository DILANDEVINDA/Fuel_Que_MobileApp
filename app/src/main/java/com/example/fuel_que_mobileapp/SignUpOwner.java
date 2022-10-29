package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.OwnerAndStationModel;
import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpOwner extends AppCompatActivity {

    EditText Name,Email,Password,MNumber,SName,Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_owner);

        Name = findViewById(R.id.editTextNameOfOwner);
        Email = findViewById(R.id.editTextEmailOfOwner);
        Password = findViewById(R.id.editTextPasswordOfOwner);
        MNumber = findViewById(R.id.editTextMNumberOfOwner);
        SName = findViewById(R.id.editTextFStationNameOfOwner);
        Location = findViewById(R.id.editTextSLocationOfOwner);
        Button signup = findViewById(R.id.btnSignupInOwner);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] message = {""};
                UserModel user = new UserModel(Name.getText().toString(),Email.getText().toString(),Password.getText().toString(),MNumber.getText().toString(),"Owner");
                OwnerAndStationModel oandS = new OwnerAndStationModel(user,SName.getText().toString(),Location.getText().toString(),1000,2000,3000,4000);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:45455/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserAPI api = retrofit.create(UserAPI.class);
                Call<Void> call = api.createUser(user);

                call.enqueue(new Callback<Void>() {
                    boolean result = false;

                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() == 200){
                            message[0] = "";
                        }else{
                            message[0] = "User Creation Unsuccessfully !";
                            Log.d("response code ",String.valueOf(false));

                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }

                });


                Toast.makeText(SignUpOwner.this,message[0], Toast.LENGTH_LONG);

                Intent i = new Intent(SignUpOwner.this, Login.class);
                startActivity(i);
                finish();

            }
        });
    }
}