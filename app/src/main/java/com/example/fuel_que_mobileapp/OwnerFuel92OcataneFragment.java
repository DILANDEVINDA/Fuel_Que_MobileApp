package com.example.fuel_que_mobileapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.FuelStationAPI;
import com.example.fuel_que_mobileapp.models.user.FuelTypeModel;
import com.example.fuel_que_mobileapp.models.user.LoginCredentialsModel;
import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OwnerFuel92OcataneFragment extends Fragment {

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    private EditText fuelFinihingtimePopUP,fueslArrivalTimePopUP,fuelArrivalDatePopUP,carryinhLitresPopUP;
    private Button cancel,update,save;
    private ProgressBar progressBar;
    private String carryingFuel,fuelFinishTime,fuelArrivalDate,fuelArrivalTime,userID;
    private int remainingFuel;

    public OwnerFuel92OcataneFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            fuelFinishTime = getArguments().getString("FuelFinishTime");
            fuelArrivalDate = getArguments().getString("FuelArrivalDate");
            remainingFuel = getArguments().getInt("RemainingFuel");
            carryingFuel = getArguments().getString("CarryingFuel");
            fuelArrivalTime = getArguments().getString("FuelArrivalTime");
            userID = getArguments().getString("UserId");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_owner_fuel92_ocatane, container, false);
        update = (Button)rootView.findViewById(R.id.btnFragment92OcataneUpdate);

        TextView txtfuelFinishTime = rootView.findViewById(R.id.textVie18);
        TextView txtfuelArrivalDate = rootView.findViewById(R.id.textVie22);
        TextView txtCarryingAmount = rootView.findViewById(R.id.textVie24);
        TextView txtfuelArrivalTime = rootView.findViewById(R.id.textVie20);
        TextView txtprogresstxtView = rootView.findViewById(R.id.progressBar_textView92);
        progressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar92);

        txtfuelFinishTime.setText(fuelFinishTime);
        txtfuelArrivalDate.setText(fuelArrivalDate);
        txtCarryingAmount.setText(carryingFuel);
        txtfuelArrivalTime.setText(fuelArrivalTime);

        double remainingfuelConvert = (remainingFuel/10000.00) * 100.00;
        Log.d("converted value ", String.valueOf(remainingfuelConvert));
        Log.d("remainigFuel value ", String.valueOf(remainingFuel/10000));

        progressBar.setProgress((int)remainingfuelConvert);
        txtprogresstxtView.setText(String.valueOf(remainingfuelConvert)+"%");

         update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogbuilder = new AlertDialog.Builder(OwnerFuel92OcataneFragment.this.getActivity());
                final View update92PopView = getLayoutInflater().inflate(R.layout.popupfor92,null);

                fuelFinihingtimePopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelFinishingTime);
                fuelArrivalDatePopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelArrivalDate);
                fueslArrivalTimePopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelArrivalTime);
                carryinhLitresPopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelAmount);

                fuelFinihingtimePopUP.setText(fuelFinishTime);
                fuelArrivalDatePopUP.setText(fuelArrivalDate);
                fueslArrivalTimePopUP.setText(fuelArrivalTime);
                carryinhLitresPopUP.setText(carryingFuel);

                cancel = (Button) update92PopView.findViewById(R.id.btnPopUpCancel);
                save = (Button) update92PopView.findViewById(R.id.btnPopUpSave);

                dialogbuilder.setView(update92PopView);
                dialog = dialogbuilder.create();
                dialog.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //updating using api

                        FuelTypeModel updateInfo = new FuelTypeModel("Fuel92",userID,fuelArrivalDatePopUP.getText().toString(),fuelFinihingtimePopUP.getText().toString(),fueslArrivalTimePopUP.getText().toString(),Integer.parseInt(carryinhLitresPopUP.getText().toString()));

                        //Api Caller
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://192.168.1.6:45455/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        FuelStationAPI api = retrofit.create(FuelStationAPI.class);
                        Call<Void> call = api.updateSpecificFuelStation(userID,updateInfo);

                        //Invoking th API
                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.code() == 200){
                                    txtfuelFinishTime.setText(fuelFinihingtimePopUP.getText().toString());
                                    txtfuelArrivalDate.setText(fuelArrivalDatePopUP.getText().toString());
                                    txtCarryingAmount.setText(fueslArrivalTimePopUP.getText().toString());
                                    txtfuelArrivalTime.setText(carryinhLitresPopUP.getText().toString());

                                    dialog.dismiss();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });
                        //end of api calling
                    }
                });
            }
        });

        return rootView;
    }

}