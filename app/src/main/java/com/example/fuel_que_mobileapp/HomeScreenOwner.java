package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
    private static final String SHARED_PREFS = "shared_prefs";
    private TextView Nametxtview,Emaitxtview;
    private FuelStationModel fuelStationDetails;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String emailStr,nameStr,userId;
    private SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen_owner);

        swipeRefreshLayout = findViewById(R.id.refreshLayoutOwner);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        emailStr = sharedpreferences.getString("email_key", null);
        nameStr = sharedpreferences.getString("name_key", null);
        userId = sharedpreferences.getString("user_id", null);

        octane92 = findViewById(R.id.btnOwnerFuel92);
        octane95 = findViewById(R.id.btnOwnerFuel95);
        autodiesel = findViewById(R.id.btnOwnerFuelAutoDiesel);
        superdiesel = findViewById(R.id.btnOwnerFuelSuperDiesel);
        logOut = findViewById(R.id.imageButtonLogoutinOwnerHomescreen);
        Nametxtview = findViewById(R.id.textView4);
        Emaitxtview = findViewById(R.id.textView5);

        Nametxtview.setText(nameStr);
        Emaitxtview.setText(emailStr);

        //retrieving data from backend
        Log.d("Id of User ",userId);
        retievingDataFromBackend(userId);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                retievingDataFromBackend(userId);

                swipeRefreshLayout.setRefreshing(false);
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
                final OwnerFuel92OcataneFragment ocatane92Fragment = new OwnerFuel92OcataneFragment();
                Bundle b = new Bundle();
                b.putInt("RemainingFuel", fuelStationDetails.getFuelNinetytwo());
                b.putString("CarryingFuel", String.valueOf(fuelStationDetails.getFuelNinetytwoCarryingAmount()));
                b.putString("FuelFinishTime", fuelStationDetails.getFuelNinetytwoFinishing());
                b.putString("FuelArrivalDate", fuelStationDetails.getFuelNinetytwoArrivalDate());
                b.putString("FuelArrivalTime", fuelStationDetails.getFuelNinetytwoArrivalTime());
                b.putString("UserId",userId);

                ocatane92Fragment.setArguments(b);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainerViewOwner, ocatane92Fragment).commit();
            }
        });

        //Fragment calling method
        octane95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                final OwnerFuel95OcataneFragment octane95Fragment = new OwnerFuel95OcataneFragment();
                Bundle b = new Bundle();
                b.putInt("RemainingFuel", fuelStationDetails.getFuelNinetyFive());
                b.putString("CarryingFuel", String.valueOf(fuelStationDetails.getFuelNinetyFiveCarryingAmount()));
                b.putString("FuelFinishTime", fuelStationDetails.getFuelNinetyFiveFinishing());
                b.putString("FuelArrivalDate", fuelStationDetails.getFuelNinetyFiveArrivalDate());
                b.putString("FuelArrivalTime",fuelStationDetails.getFuelNinetyFiveArrivalTime());

                octane95Fragment.setArguments(b);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainerViewOwner, octane95Fragment).commit();
            }
        });

        //Fragment calling method
        autodiesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //final OwnerFuel92OcataneFragment ocatane92Fragment = new OwnerFuel92OcataneFragment();
                final OwnerFuelAutodieselFragment autodieselFragment = new OwnerFuelAutodieselFragment();
                Bundle b = new Bundle();
                b.putInt("RemainingFuel", fuelStationDetails.getAutoDiesel());
                b.putString("CarryingFuel", String.valueOf(fuelStationDetails.getAutoDieselCarryingAmount()));
                b.putString("FuelFinishTime",fuelStationDetails.getAutoDieselFinishing());
                b.putString("FuelArrivalDate", fuelStationDetails.getAutoDieselArrivalDate());
                b.putString("FuelArrivalTime", fuelStationDetails.getAutoDieselArrivalTime());

                autodieselFragment.setArguments(b);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainerViewOwner, autodieselFragment).commit();
            }
        });

        //Fragment calling method
        superdiesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //final OwnerFuel92OcataneFragment ocatane92Fragment = new OwnerFuel92OcataneFragment();
                final  OwnerFuelSuperDieselFragment superDieselFragment = new OwnerFuelSuperDieselFragment();
                Bundle b = new Bundle();
                b.putInt("RemainingFuel", fuelStationDetails.getSuperDiesel());
                b.putString("CarryingFuel", String.valueOf(fuelStationDetails.getSuperDieselCarryingAmount()));
                b.putString("FuelFinishTime", fuelStationDetails.getSuperDieselFinishing());
                b.putString("FuelArrivalDate", fuelStationDetails.getSuperDieselArrivalDate());
                b.putString("FuelArrivalTime", fuelStationDetails.getSuperDieselArrivalTime());

                superDieselFragment.setArguments(b);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainerViewOwner, superDieselFragment).commit();
            }
        });
    }

    public void retievingDataFromBackend(String id){
        Log.d("Id of the user ", id);
        //Api Caller
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:45455/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FuelStationAPI api = retrofit.create(FuelStationAPI.class);
        Call<FuelStationModel> call = api.getSpecificFuelStation(id);

        //Invoking th API
        call.enqueue(new Callback<FuelStationModel>() {
            @Override
            public void onResponse(Call<FuelStationModel> call, Response<FuelStationModel> response) {

                if(response.code() == 200){
                    Log.d("response of fuelStation",response.body().getId());

                    fuelStationDetails = new FuelStationModel(
                        response.body().getId(),
                        response.body().getOwnerId(),
                        response.body().getName(),
                        response.body().getLocation(),
                        response.body().getFuelNinetytwo(),
                        response.body().getFuelNinetytwoCarryingAmount(),
                        response.body().getFuelNinetytwoArrivalTime(),
                        response.body().getFuelNinetytwoArrivalDate(),
                        response.body().getFuelNinetytwoFinishing(),
                        response.body().getFuelNinetyFive(),
                        response.body().getFuelNinetyFiveCarryingAmount(),
                        response.body().getFuelNinetyFiveArrivalTime(),
                        response.body().getFuelNinetyFiveArrivalDate(),
                        response.body().getFuelNinetyFiveFinishing(),
                        response.body().getAutoDiesel(),
                        response.body().getAutoDieselCarryingAmount(),
                        response.body().getAutoDieselArrivalTime(),
                        response.body().getAutoDieselArrivalDate(),
                        response.body().getAutoDieselFinishing(),
                        response.body().getSuperDiesel(),
                        response.body().getSuperDieselCarryingAmount(),
                        response.body().getSuperDieselArrivalTime(),
                        response.body().getSuperDieselArrivalDate(),
                        response.body().getSuperDieselFinishing()
                    );
                }

            }

            @Override
            public void onFailure(Call<FuelStationModel> call, Throwable t) {

            }
        });
    }
}