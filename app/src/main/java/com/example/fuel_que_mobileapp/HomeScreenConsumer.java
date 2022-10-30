package com.example.fuel_que_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeScreenConsumer extends AppCompatActivity {

    private EditText searchField;
    String emailStr,nameStr;
    SharedPreferences sharedpreferences;
    private ImageButton logOut;
    public static final String SHARED_PREFS = "shared_prefs";
    public TextView Nametxtview,Emaitxtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen_consumer);

        searchField = findViewById(R.id.editTextSearchINConsumer);

        searchField.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int DRAWABLE_RIGHT = 2;

                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= (searchField.getRight() - searchField.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        Log.d("Icon working",searchField.getText().toString());
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
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();

                editor.apply();

                Intent i = new Intent(HomeScreenConsumer.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}