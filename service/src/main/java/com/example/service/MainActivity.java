package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int num;
    private ControlService mService;
    private ServiceConnection sc;
    private Button start;
    private Button bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG", "onClick: start" );
                startService(new Intent(MainActivity.this,StartService.class));
            }
        });
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAG", "onClick: bind" );
                bindService(new Intent(MainActivity.this, BindService.class), sc, Context.BIND_AUTO_CREATE);
            }
        });
        //test bind and startService
        //bind ServiceConnection



//        startService(new Intent(this, ControlService.class));
//        bindService(new Intent(this, ControlService.class), MainActivity.this, Context.BIND_AUTO_CREATE);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    Log.e("aaa", "a我先来的: " + i);
//                }
//
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    Log.e("bbb", "b我先来的" + i);
//                }
//
//            }
//        }).start();
    }


    public void init() {
        start = findViewById(R.id.start);
        bind = findViewById(R.id.bind);
        sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder service) {
                BindService.SimpleBinder simpleBinder = (BindService.SimpleBinder) service;
                Log.e("TAG1", "onServiceConnected: " + simpleBinder.add(3, 5));
                Log.e("TAG2", "onServiceConnected: " + simpleBinder.getService().toString());
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.e("3", "onServiceDisconnected: ");
            }
        };
    }
}