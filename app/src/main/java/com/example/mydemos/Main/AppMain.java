package com.example.mydemos.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mydemos.R;
import com.example.mydemos.app.FragmentStack;
import com.example.mydemos.app.Tabs;
import com.example.mydemos.app.TopTabFragment;

public class AppMain extends AppCompatActivity {
private Button frag;
private Button topTabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        frag = findViewById(R.id.fragment);

        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMain.this, FragmentStack.class);
                startActivity(intent);
            }
        });
        topTabs = findViewById(R.id.fragmentTopTabs);
        topTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMain.this, Tabs.class);
                startActivity(intent);
            }
        });

    }

}