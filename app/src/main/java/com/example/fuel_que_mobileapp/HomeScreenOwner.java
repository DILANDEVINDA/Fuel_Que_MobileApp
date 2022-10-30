package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeScreenOwner extends AppCompatActivity {

    private Button octane92,octane95,autodiesel, superdiesel;
    private ImageButton logOut;
    public static final String SHARED_PREFS = "shared_prefs";
    public TextView Nametxtview,Emaitxtview;

    String emailStr,nameStr;
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

        Nametxtview.setText(nameStr);
        Emaitxtview.setText(emailStr);

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

        octane92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewOwner, OwnerFuel92OcataneFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

            }
        });

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