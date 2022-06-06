package com.example.nvtest;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ConstraLayout extends AppCompatActivity {
    private AlertDialog dialog;
    private Context context;
    private Button button;
    private Button save;
    private Button cancel;
    private EditText pattern;
    private EditText strength;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constrainlayout);


    }
}