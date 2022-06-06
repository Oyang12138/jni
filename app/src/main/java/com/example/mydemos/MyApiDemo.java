package com.example.mydemos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyApiDemo extends AppCompatActivity {
    private ListView listView;
    private String[] data = {"Accessibility","动画","App","Content","Graphics","Hardware","NFC","media","OS","Preference","Security","Test","Views"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_api_demo);
        //适配器，将数组数据传给listview
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MyApiDemo.this, android.R.layout.simple_list_item_1,data);
        listView  = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MyApiDemo.this, l+"点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }



}