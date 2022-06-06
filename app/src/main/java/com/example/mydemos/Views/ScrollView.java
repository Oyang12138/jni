package com.example.mydemos.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.mydemos.R;

public class ScrollView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,AutoComplete1.COUNTRIES);
        AutoCompleteTextView edit1 = findViewById(R.id.edit1);
        AutoCompleteTextView edit2 = findViewById(R.id.edit2);
        edit1.setAdapter(adapter);
        edit2.setAdapter(adapter);
    }

}