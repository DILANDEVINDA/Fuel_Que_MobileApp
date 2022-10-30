package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.LoginCredentialsModel;
import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    RadioButton consumer,owner;
    Button btnContinue,btnLogin;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registration = findViewById(R.id.textVewRegisterFromLogin);
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.editTextLoginEmail);
        password = findViewById(R.id.editTextLoginPassword);

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
                LoginCredentialsModel loginCredentials = new LoginCredentialsModel(email.getText().toString(),password.getText().toString());

                //Api Caller
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:45455/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserAPI api = retrofit.create(UserAPI.class);
                Call<UserModel> call = api.authenticateUser(loginCredentials);

                //Invoking th API
                call.enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        if(response.code() == 200){
                            Log.d("response","working");

                            if(response.body().getUsertype().equals("Owner")){
                                Intent i = new Intent(Login.this, HomeScreenOwner.class);
                                startActivity(i);
                                finish();
                            }else if(response.body().getUsertype().equals("Consumer")){
                                Intent i = new Intent(Login.this, HomeScreenConsumer.class);
                                startActivity(i);
                                finish();
                            }
                        }else{
                            Toast.makeText(Login.this,"User Not Available",Toast.LENGTH_LONG);
                            /*Intent i = new Intent(SignUpOwner.this, Login.class);
                            startActivity(i);
                            finish();*/

                        }
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        Log.d("API failed : ",t.getMessage().toString());
                    }
                });
            }
        });


    }
}