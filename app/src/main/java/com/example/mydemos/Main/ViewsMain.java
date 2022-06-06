package com.example.mydemos.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mydemos.R;
import com.example.mydemos.Views.DateWidgets1;
import com.example.mydemos.Views.MyChronometer;
import com.example.mydemos.Views.MyCountDownTimer;
import com.example.mydemos.Views.ScrollView;

public class ViewsMain extends AppCompatActivity {
    private Button chronometer;
    private Button data;
    private Button countdown;
    private Button scroll;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_main);
        chronometer = findViewById(R.id.chronometer);
        countdown = findViewById(R.id.countdowntimer);
        data = findViewById(R.id.dataWidgets);
        scroll = findViewById(R.id.scrollview);
        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewsMain.this, MyChronometer.class);
                startActivity(intent);
            }
        });
        countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewsMain.this, MyCountDownTimer.class);
                startActivity(intent);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewsMain.this, DateWidgets1.class);
                startActivity(intent);
            }
        });
        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewsMain.this, ScrollView.class);
                startActivity(intent);
            }
        });


    }
}