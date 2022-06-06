package com.example.carseting;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import selectbutton.RearLampselect;

public class MainActivity extends AppCompatActivity {
private CheckBox orag;
private SeekBar seekBar;
private Button btn;
private ImageView imageView;
private RearLampselect rearLampselect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        seekBar = findViewById(R.id.seekbar);
        seekBar.setClickable(false);
        btn = findViewById(R.id.finish);
        imageView = findViewById(R.id.close);
        LinearGradient test = new LinearGradient(0f,0f,300f,0f,new int[]{ 0xFFFF0000,0xFFFF00FF, 0xFFFFFF00,
                0xFF00FFFF, 0xFF00FF00,0xFF0000FF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setShader(test);
        seekBar.setProgressDrawable(shapeDrawable);
        seekBar.setBackgroundResource(R.color.purple_500);
        rearLampselect = findViewById(R.id.rear_lamp_select);
        rearLampselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RearLampselect.setGrery();
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });
        RearLampselect.setWhiteClose();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        Canvas canvas = new Canvas();
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        canvas.drawCircle(100,100,10,p);

    }
}