package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    String emailStr,userTypeStr;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        emailStr = sharedpreferences.getString("email_key", null);
        userTypeStr = sharedpreferences.getString("user_type", null);

        ImageView goButton = findViewById(R.id.imageViewSpashScreenGoBtn);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (emailStr != null) {
            //Log.d("session values :" , emailStr + " " + passwordStr + " " + userTypeStr);
            if(userTypeStr != null && userTypeStr.equals("Owner")){
                Intent i = new Intent(SplashScreen.this, HomeScreenOwner.class);
                startActivity(i);
            }else if(userTypeStr != null && userTypeStr.equals("Consumer")){
                Intent i = new Intent(SplashScreen.this, HomeScreenConsumer.class);
                startActivity(i);
            }
        }
    }
}