package com.example.mydemos.vibratortest;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydemos.R;

public class VibratorTest extends AppCompatActivity {
    private Button start;
    private Button end;
    private Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator_test);
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(new long[]{500,100,500,100,500,100},0);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
            }
        });
    }
}