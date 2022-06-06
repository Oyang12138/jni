package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Switch extends AppCompatActivity {
    private ImageView imageView;
    boolean isInLoopOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        imageView = findViewById(R.id.img);
        cliclInLoop();

    }

    public void setLoopState(boolean isOn) {
        isInLoopOn = isOn;
        imageView.setImageResource(isOn ? R.drawable.ic_baseline_mic_24:R.drawable.ic_baseline_mic_off_24);
        imageView.setBackgroundResource(isOn?R.color.red:R.color.white);
    }
    private void cliclInLoop(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isInLoopOn = !isInLoopOn;
                setLoopState(isInLoopOn);
            }
        });
    }
}