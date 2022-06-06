package com.example.mydemos.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.mydemos.R;

import java.security.PrivateKey;

public class MyChronometer extends AppCompatActivity {
    private Button start;
    private Button stop;
    private Button reset;
    private Button setformat;
    private Button clear;


    //计时器
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
        //计时器
        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);
        setformat = findViewById(R.id.setformatstring);
        clear = findViewById(R.id.clean);

        start.setOnClickListener(mystart);
        stop.setOnClickListener(mystop);
        reset.setOnClickListener(myreset);
        setformat.setOnClickListener(mysetformat);
        setformat.setOnClickListener(myclear);

    }


    View.OnClickListener mystart = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            chronometer.start();
            Log.i("TAG", "start()");
        }
    };
    View.OnClickListener mystop = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            chronometer.stop();
            Log.i("TAG", "stop()");
        }
    };
    View.OnClickListener myreset = new View.OnClickListener() {
        //清零
        @Override
        public void onClick(View view) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            Log.i("TAG", "setBase:(SystemClock.elapsedRealtime()) 计时清零");
        }
    };
    View.OnClickListener mysetformat = new View.OnClickListener() {
        //设置格式字符串
        @Override
        public void onClick(View view) {
            chronometer.setFormat("Format time (%s)");
            Log.i("TAG", "setFormat:字符串格式");
        }
    };
    View.OnClickListener myclear = new View.OnClickListener() {
       //去掉格式字符串
        @Override
        public void onClick(View view) { chronometer.setFormat(null);}
    };



}