package com.example.mydemos.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemos.R;

public class MyCountDownTimer extends AppCompatActivity {
    private CountDownTimer countDownTimer;
    private TextView textView;
    private Button start;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_count_down_timer);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        textView = findViewById(R.id.tv1);
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                Log.i("TAG", "seconds remaining" + l / 1000);
                String time= String.valueOf(l/1000);
                textView.setText(time);

            }

            @Override
            public void onFinish() {
                Log.i("TAG", "onFinish: done");
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //计时总时间，倒计时时间间隔
               countDownTimer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
            }
        });
    }
}