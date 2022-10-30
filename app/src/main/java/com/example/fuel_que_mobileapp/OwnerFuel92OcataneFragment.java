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

public class OwnerFuel92OcataneFragment extends Fragment {

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    private EditText fuelFinihingtimePopUP,fueslArrivalTimePopUP,fuelArrivalDatePopUP,carryinhLitresPopUP;
    private Button cancel,update,save;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_owner_fuel92_ocatane, container, false);
        update = (Button)rootView.findViewById(R.id.btnFragment92OcataneUpdate);

        TextView fuelFinishTime = rootView.findViewById(R.id.textVie18);
        TextView fuelArrivalDate = rootView.findViewById(R.id.textVie22);
        TextView CarryingAmount = rootView.findViewById(R.id.textVie24);
        TextView fuelArrivalTime = rootView.findViewById(R.id.textVie20);
        TextView progresstxtView = rootView.findViewById(R.id.progressBar_textView92);
        progressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar92);

        Bundle bundle = getArguments();
        String message1 = bundle.getString("FuelFinishTime");
        String message2 = bundle.getString("FuelArrivalDate");
        int message3 = bundle.getInt("RemainingFuel");
        String message4 = bundle.getString("FuelArrivalTime");

        fuelFinishTime.setText(message1);
        fuelArrivalDate.setText(message2);
        CarryingAmount.setText(message3);
        fuelArrivalTime.setText(message4);

        progressBar.setProgress(message3/10000 * 100);
        progresstxtView.setText(String.valueOf(message3));

         update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogbuilder = new AlertDialog.Builder(OwnerFuel92OcataneFragment.this.getActivity());
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