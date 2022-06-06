package com.example.content;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FileOperator extends AppCompatActivity {
    private EditText name;
    private EditText text;
    private Button write;
    private Button read;
    private Button clean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_operator);

    }
}