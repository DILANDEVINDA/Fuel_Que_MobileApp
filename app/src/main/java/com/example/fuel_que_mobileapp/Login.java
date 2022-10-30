package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    RadioButton consumer,owner;
    Button btnContinue,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registration = findViewById(R.id.textVewRegisterFromLogin);
        btnLogin = findViewById(R.id.btnLogin);

        //Separate the user from resgistration
        //Owner has more fields fill in the registration form
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogbuilder = new AlertDialog.Builder(Login.this);
                final View userNavigation = getLayoutInflater().inflate(R.layout.popforuserseparation,null);

                consumer = (RadioButton) userNavigation.findViewById(R.id.radioButtonUserSeparationConsumer);
                owner = (RadioButton) userNavigation.findViewById(R.id.radioButtonUserSeparationOwner);
                btnContinue = userNavigation.findViewById(R.id.btnUserSeparationContinue);

                dialogbuilder.setView(userNavigation);
                dialog = dialogbuilder.create();
                dialog.show();

                btnContinue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (consumer.isChecked()){
                            Intent i = new Intent(Login.this, SignUpConsumer.class);
                            startActivity(i);
                            finish();
                        }else if(owner.isChecked()){
                            Intent i = new Intent(Login.this, SignUpOwner.class);
                            startActivity(i);
                            finish();
                        }

                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}