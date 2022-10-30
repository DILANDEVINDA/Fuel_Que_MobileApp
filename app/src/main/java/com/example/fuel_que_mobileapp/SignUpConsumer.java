package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fuel_que_mobileapp.models.user.OwnerAndStationModel;
import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpConsumer extends AppCompatActivity {
    EditText name,email,password,mnumber;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_consumer);

        name = findViewById(R.id.editTextNameOfOwner);
        email = findViewById(R.id.editTextEmailOfConsumer);
        password = findViewById(R.id.editTextLoginPasswordOfConsumer);
        mnumber = findViewById(R.id.editTextMNumberOfConsumer);

        signUp = findViewById(R.id.btnSignUPForConsumer);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel user = new UserModel(name.getText().toString(),email.getText().toString(),password.getText().toString(),mnumber.getText().toString(),"Consumer");

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:45455/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserAPI api = retrofit.create(UserAPI.class);
                Call<Void> call = api.createConsumer(user);

                call.enqueue(new Callback<Void>() {

                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() == 200){
                            Log.d("response","working");
                            Intent i = new Intent(SignUpConsumer.this, Login.class);
                            startActivity(i);
                            finish();
                        }else{
                            Log.d("response","not working");
                            Intent i = new Intent(SignUpConsumer.this, Login.class);
                            startActivity(i);
                            finish();

                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("API failed : ",t.getMessage().toString());
                    }

                });
            }
        });
    }
}