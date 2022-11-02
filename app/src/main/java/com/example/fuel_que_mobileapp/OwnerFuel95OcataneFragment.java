package com.example.fuel_que_mobileapp;

import android.app.AlertDialog;
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

public class OwnerFuel95OcataneFragment extends Fragment {

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    private EditText fuelFinihingtimePopUP,fueslArrivalTimePopUP,fuelArrivalDatePopUP,carryinhLitresPopUP;
    private Button cancel,update,save;
    private ProgressBar progressBar;
    private String carryingFuel,fuelFinishTime,fuelArrivalDate,fuelArrivalTime;
    private int remainingFuel;

    public OwnerFuel95OcataneFragment() {
        // Required empty public constructor
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_owner_fuel95_ocatane, container, false);

        update = (Button)rootView.findViewById(R.id.btnFragment95OcataneUpdate);

        TextView txtfuelFinishTime = rootView.findViewById(R.id.fuelFinishOwner95);
        TextView txtfuelArrivalDate = rootView.findViewById(R.id.fuelArrivalDateOwner95);
        TextView txtCarryingAmount = rootView.findViewById(R.id.fuelCarryingAmountOwner95);
        TextView txtfuelArrivalTime = rootView.findViewById(R.id.fuelArrivalTimeOwner95);
        TextView txtprogresstxtView = rootView.findViewById(R.id.progressBar_textView95);
        progressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar95);

        txtfuelFinishTime.setText(fuelArrivalTime);
        txtfuelArrivalDate.setText(fuelArrivalDate);
        txtCarryingAmount.setText(carryingFuel);
        txtfuelArrivalTime.setText(fuelFinishTime);

        double remainingfuelConvert = (remainingFuel/10000.00) * 100.00;
        Log.d("converted value ", String.valueOf(remainingfuelConvert));
        Log.d("remainigFuel value ", String.valueOf(remainingFuel/10000));

        progressBar.setProgress((int)remainingfuelConvert);
        txtprogresstxtView.setText(String.valueOf(remainingfuelConvert)+"%");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogbuilder = new AlertDialog.Builder(OwnerFuel95OcataneFragment.this.getActivity());
                final View update92PopView = getLayoutInflater().inflate(R.layout.popupfor92,null);

                fuelFinihingtimePopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelFinishingTime);
                fuelArrivalDatePopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelArrivalDate);
                fueslArrivalTimePopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelArrivalTime);
                carryinhLitresPopUP = (EditText) update92PopView.findViewById(R.id.editTextTextPopUpFuelAmount);

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
            }
        });


        return rootView;
    }
}