package com.example.mydemos.Accessibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.example.mydemos.R;

public class SeekBarTest extends AppCompatActivity {
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.i("TAG", "onProgressChanged: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("TAG", "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("TAG", "onStopTrackingTouch: ");
            }
        });

    }
}