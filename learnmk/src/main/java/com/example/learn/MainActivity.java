package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jnipackage.Hello;

public class MainActivity extends AppCompatActivity {
private TextView textView;
private Hello hello = new Hello();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        textView.setText(hello.getString());
    }
}