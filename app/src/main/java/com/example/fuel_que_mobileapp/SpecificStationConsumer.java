package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpecificStationConsumer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_station_consumer);

        Button filter = findViewById(R.id.btnSpecificStationFilter);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SpecificStationConsumer.this, SpecificStationConsumerTwo.class);
                startActivity(i);
                finish();
            }
        });


    }
}