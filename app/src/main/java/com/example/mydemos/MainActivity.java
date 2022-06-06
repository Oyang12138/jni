package com.example.mydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mydemos.Main.AppMain;
import com.example.mydemos.Main.TextMain;
import com.example.mydemos.Main.ViewsMain;

public class MainActivity extends AppCompatActivity {
    private Button text;
    private Button views;
    private Button app;
    private String[][] nn;
    private int[] x = {5, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        views = findViewById(R.id.view);
        app = findViewById(R.id.app);

        Intent intent = getIntent();
        String path = intent.getStringExtra("com.example.mydemos.Path");
        Log.i("TAG", "onCreate: " + path);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TextMain.class);
                startActivity(intent);
            }
        });
        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewsMain.class);
                startActivity(intent);

            }
        });
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AppMain.class);
                startActivity(intent);

            }
        });

    }

}