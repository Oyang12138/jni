package com.example.accountname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View convertView = View.inflate(MainActivity.this, R.layout.account_list, null);
        ListView listView = (ListView)convertView.findViewById(R.id.list);
        AccoutAdapter accoutAdapter = new AccoutAdapter(MainActivity.this);
        listView.setAdapter(accoutAdapter);
        accoutAdapter.getAccountname();
        Log.i("TAG", "onCreate: "+accoutAdapter);

    }
}