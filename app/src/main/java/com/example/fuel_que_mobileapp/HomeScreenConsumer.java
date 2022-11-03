package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.FuelStationAdapter;
import com.example.fuel_que_mobileapp.models.user.StationCardViewModel;

import java.util.ArrayList;

public class HomeScreenConsumer extends AppCompatActivity  {

    private EditText searchField;
    String emailStr,nameStr;
    SharedPreferences sharedpreferences;
    private ImageButton logOut;
    public static final String SHARED_PREFS = "shared_prefs";
    public TextView Nametxtview,Emaitxtview;
    private ArrayList<StationCardViewModel> stationList = new ArrayList<StationCardViewModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen_consumer);
        RecyclerView courseRV = findViewById(R.id.listOfFuelStationInConsumer);

        searchField = findViewById(R.id.editTextSearchINConsumer);

        searchField.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int DRAWABLE_RIGHT = 2;

                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= (searchField.getRight() - searchField.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here

                        stationList.add(new StationCardViewModel("Renuka Fuel Station",R.drawable.ceypetco));
                        stationList.add(new StationCardViewModel("Sarath Fuel Station",R.drawable.ioc));
                        stationList.add(new StationCardViewModel("Malindu Fuel Station",R.drawable.ioc));
                        stationList.add(new StationCardViewModel("Iresha Fuel Station",R.drawable.ceypetco));
                        stationList.add(new StationCardViewModel("Hasitha Fuel Station",R.drawable.ceypetco));
                        stationList.add(new StationCardViewModel("Lakni Fuel Station",R.drawable.ceypetco));
                        stationList.add(new StationCardViewModel("Dilan Fuel Station",R.drawable.ceypetco));
                        stationList.add(new StationCardViewModel("Hussain Fuel Station",R.drawable.ceypetco));


                        FuelStationAdapter stationAdapter = new FuelStationAdapter(HomeScreenConsumer.this, stationList);

                        // below line is for setting a layout manager for our recycler view.
                        // here we are creating vertical list so we will provide orientation as vertical
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreenConsumer.this, LinearLayoutManager.VERTICAL, false);

                        // in below two lines we are setting layoutmanager and adapter to our recycler view.
                        courseRV.setLayoutManager(linearLayoutManager);
                        courseRV.setAdapter(stationAdapter);

                        stationAdapter.setOnItemClickListener(new FuelStationAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                String Title = stationList.get(position).getFuel_station_name();
                                Toast.makeText(HomeScreenConsumer.this,"card title" + Title,Toast.LENGTH_LONG);
                            }
                        });
                        return true;
                    }
                }
                return false;
            }
        });

        logOut = findViewById(R.id.imageButtonLogoutinConsumerHomescreen);
        Nametxtview = findViewById(R.id.textView4);
        Emaitxtview = findViewById(R.id.textView5);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        emailStr = sharedpreferences.getString("email_key", null);
        nameStr = sharedpreferences.getString("name_key", null);

        Nametxtview.setText(nameStr);
        Emaitxtview.setText(emailStr);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();

                editor.apply();*/

                Intent i = new Intent(HomeScreenConsumer.this, SpecificStationConsumer.class);
                startActivity(i);
                finish();
            }
        });
    }

}