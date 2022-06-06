package com.example.mydemos.Accessibility;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mydemos.R;

public class System_setting extends AppCompatActivity {
    private static final Intent intent1 = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);

    private Button btn ;
    private Button btn2;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_setting);
        btn = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        imageView = findViewById(R.id.img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"rotationY",0f,90f);
                Log.i("TAG", "onClick: ");
                objectAnimator.setDuration(500);
                objectAnimator.start();
            }
        });


    }
}