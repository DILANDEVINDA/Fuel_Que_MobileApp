package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.FuelStationAPI;
import com.example.fuel_que_mobileapp.models.user.FuelStationModel;
import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeScreenOwner extends AppCompatActivity {

    private Button octane92,octane95,autodiesel, superdiesel;
    private ImageButton logOut;
    public static final String SHARED_PREFS = "shared_prefs";
    public TextView Nametxtview,Emaitxtview;

    String emailStr,nameStr,userId;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen_owner);

        octane92 = findViewById(R.id.btnOwnerFuel92);
        octane95 = findViewById(R.id.btnOwnerFuel95);
        autodiesel = findViewById(R.id.btnOwnerFuelAutoDiesel);
        superdiesel = findViewById(R.id.btnOwnerFuelSuperDiesel);
        logOut = findViewById(R.id.imageButtonLogoutinOwnerHomescreen);
        Nametxtview = findViewById(R.id.textView4);
        Emaitxtview = findViewById(R.id.textView5);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        emailStr = sharedpreferences.getString("email_key", null);
        nameStr = sharedpreferences.getString("name_key", null);
        userId = sharedpreferences.getString("user_id", null);

        Nametxtview.setText(nameStr);
        Emaitxtview.setText(emailStr);

        //Api Caller
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:45455/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FuelStationAPI api = retrofit.create(FuelStationAPI.class);
        Call<FuelStationModel> call = api.getSpecificFuelStation(userId);

        //Invoking th API to retrieve fuel station data
        call.enqueue(new Callback<FuelStationModel>() {
            @Override
            public void onResponse(Call<FuelStationModel> call, Response<FuelStationModel> response) {
                if(response.code() == 200){

                }
            }

            @Override
            public void onFailure(Call<FuelStationModel> call, Throwable t) {

            }
        });

        //Logout method
        //this will remove the session
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();

                editor.apply();

                Intent i = new Intent(HomeScreenOwner.this, Login.class);
                startActivity(i);
                finish();
            }
        });

        //Fragment calling method
        octane92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                final OwnerFuel92OcataneFragment myFragment = new OwnerFuel92OcataneFragment();
                Bundle b = new Bundle();
                b.putInt("RemainingFuel", 4000);
                b.putString("FuelFinishTime", "7:00 pm");
                b.putString("FuelArrivalDate", "2022/10/14");
                b.putString("FuelArrivalTime", "9:00 pm");

                myFragment.setArguments(b);
                fragmentTransaction.add(R.id.fragmentContainerViewOwner, myFragment).commit();
                /*fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewOwner, OwnerFuel92OcataneFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();*/
            }
        });

        //Fragment calling method
        octane95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewOwner, OwnerFuel95OcataneFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

            }
        });

        //Fragment calling method
        autodiesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewOwner, OwnerFuelAutodieselFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

            }
        });

        //Fragment calling method
        superdiesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewOwner, OwnerFuelSuperDieselFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

            }
        });
    }
}