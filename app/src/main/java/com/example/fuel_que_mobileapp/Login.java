package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuel_que_mobileapp.models.user.LoginCredentialsModel;
import com.example.fuel_que_mobileapp.models.user.SqliteDbHelper;
import com.example.fuel_que_mobileapp.models.user.UserAPI;
import com.example.fuel_que_mobileapp.models.user.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    private RadioButton consumer,owner;
    private Button btnContinue,btnLogin;
    private EditText email,password;
    private static final String SHARED_PREFS = "shared_prefs";
    private static final String EMAIL_KEY = "email_key";
    private static final String NAME_KEY = "name_key";
    private static final String USER_ID = "user_id";
    private static final String USER_TYPE = "user_type";

    //session management
    private String emailStr,userTypeStr,startingEmailValue;
    private SharedPreferences sharedpreferences;

    //sqlite variables
    private SqliteDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registration = findViewById(R.id.textVewRegisterFromLogin);
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.editTextLoginEmail);
        password = findViewById(R.id.editTextLoginPassword);

        //sqlite db part of the login. this will keep login credentials
        // creating a new dbhandler class
        // and passing our context to it.
        startingEmailValue = email.getText().toString();
        db = new SqliteDbHelper(Login.this);
        boolean result = db.tableExists();
        if(result){
            ArrayList<LoginCredentialsModel> users = new ArrayList<>();
            users = db.readUser();
            String userEmail = "";
            String userPassword = "";

            for (LoginCredentialsModel user : users) {
                userEmail = user.getEmail();
                userPassword = user.getPassword();
            }

            if(!userEmail.isEmpty() && !userPassword.isEmpty()){
                email.setText(userEmail);
                password.setText(userPassword);
            }
        }

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        emailStr = sharedpreferences.getString("email_key", null);
        userTypeStr = sharedpreferences.getString("user_type", null);

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

                // below line is to get data from all edit text fields.
                String emailStrAfterClickingLogin = email.getText().toString();
                String passwordStrAfterClickingLogin = password.getText().toString();

                // validating if the text fields are empty or not.
                if (emailStrAfterClickingLogin.isEmpty() && passwordStrAfterClickingLogin.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if(!startingEmailValue.isEmpty()){
                        authenticatingUserFromBackend(emailStrAfterClickingLogin,passwordStrAfterClickingLogin);
                    }

                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    db.addUser(emailStrAfterClickingLogin,passwordStrAfterClickingLogin);

                    authenticatingUserFromBackend(emailStrAfterClickingLogin,passwordStrAfterClickingLogin);
                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (emailStr != null ) {
            //Log.d("session values :" , emailStr + " " + passwordStr + " " + userTypeStr);
            if(userTypeStr != null && userTypeStr.equals("Owner")){
                Intent i = new Intent(Login.this, HomeScreenOwner.class);
                startActivity(i);
            }else if(userTypeStr != null && userTypeStr.equals("Consumer")){
                Intent i = new Intent(Login.this, HomeScreenConsumer.class);
                startActivity(i);
            }
        }
    }

    public void authenticatingUserFromBackend(String email,String password){
        LoginCredentialsModel loginCredentials = new LoginCredentialsModel(email,password);

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
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString(EMAIL_KEY, response.body().getEmail());
                        editor.putString(NAME_KEY, response.body().getName());
                        editor.putString(USER_ID, response.body().getId());
                        editor.putString(USER_TYPE, response.body().getUsertype());

                        // to save our data with key and value.
                        boolean result = editor.commit();

                        // starting new activity.
                        if(result){
                            Intent i = new Intent(Login.this, HomeScreenOwner.class);
                            startActivity(i);
                            finish();
                        }
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
}