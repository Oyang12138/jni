package com.example.mydemos.text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mydemos.R;

public class LogTextBox extends AppCompatActivity {
    private LogTextBox1 logTextBox1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_text_box);
        logTextBox1 = findViewById(R.id.text);
        Button button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logTextBox1.append("This is a test\n");
            }
        });
        Button clean = findViewById(R.id.clean);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logTextBox1.setText(null);
            }
        });
    }
}