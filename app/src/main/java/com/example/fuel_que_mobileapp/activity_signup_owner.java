package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_signup_owner extends AppCompatActivity {

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
                String details = Name.getText().toString() + " " + Email.getText().toString() + " " + Password.getText().toString()+ " " + MNumber.getText().toString()+ " " + SName.getText().toString()+ " " + Location.getText().toString();
                UserModel user = new UserModel(Name.getText().toString(),Email.getText().toString(),Password.getText().toString(),MNumber.getText().toString(),"Owner");

                Log.d("Typed words = " , details);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.8.102:45455/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserAPI api = retrofit.create(UserAPI.class);
                Call<Void> call = api.createUser(user);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.d("response code ",String.valueOf(response.code() == 200));
                        if( 2000 != response.code()){
                            Log.d("condition woeking", "");
                            Toast.makeText(activity_signup_owner.this,"User created successfully !", Toast.LENGTH_LONG);
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

            }
        });
    }
}