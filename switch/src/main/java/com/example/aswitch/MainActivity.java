package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private float mTemperature = 18f;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView mTvTemperature;
    private ImageView raise;
    private ImageView reduce;
    private Handler mHandler = new Handler();
    private View mView;
    private float[] select = new float[]{18f, 18.5f, 19f, 19.5f, 20f, 20.5f, 21f, 21.5f, 22f, 22.5f, 23f, 23.5f
            , 24f, 24.5f, 25f, 25.5f, 26f, 26.5f, 27f, 27.5f, 28f, 28.5f, 29f, 29.5f, 30f,30.5f ,31f,31.5f, 32f};
    private static final float MIN_TEMPERATURE = 18f, MAX_TEMPERATURE = 32f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int count = (((int)MAX_TEMPERATURE-(int)MIN_TEMPERATURE)*2)+1;
        int count1 = (int)(MAX_TEMPERATURE-MIN_TEMPERATURE)*2+1;
        Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+count1, Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);
        textView3 = findViewById(R.id.tv3);
        mTvTemperature = findViewById(R.id.temp);
        raise = findViewById(R.id.raise);
        reduce = findViewById(R.id.reduce);
        setTem(mTemperature);
        String x = String.format("%s",select[6]);

        Log.e("123", "onCreate: "+Float.NaN);
        Log.e("123", "onCreate: "+(int)Float.NaN);
        Log.e("123", "onCreate: "+(int)Float.NaN);
        raise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.postDelayed(mRepeatedAction,3000);
                mTemperature = mTemperature+0.5f;
                setTem(mTemperature);
            }
        });
        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTemperature = mTemperature-0.5f;
                setTem(mTemperature);
            }
        });
//        Toast.makeText(this, "x" + mTemp, Toast.LENGTH_SHORT).show();
//        float m1 = mTemp + 0.5f;
//        Log.e("TAG", "onCreate: " + mTemp + 0.5);
//
//        Log.e("TAG", "onCreate: " + String.format("%.1f", mTemp));
//        textView.setText(String.format("%.1f", m1));
//        float m2 = mTemp + 0.5f;
//        textView2.setText(String.format("%.1f°", mTemp));
//        if (mTemp >= 15f) {
//            Toast.makeText(this, "mTemp>=15" + true, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "mTemp<=15" + false, Toast.LENGTH_SHORT).show();
//        }
//        if (mTemp < 19) {
//            Toast.makeText(this, "MainActivity.mTemp<19", Toast.LENGTH_SHORT).show();
//        }
//        textView3.setText(String.valueOf(mTemp));
//        int x = 18;

    }
    public void setTem(float tem){
        mTemperature = tem;
        if(mTemperature<MIN_TEMPERATURE){
            mTemperature = MIN_TEMPERATURE;
        }else if (mTemperature > MAX_TEMPERATURE) {
            mTemperature = MAX_TEMPERATURE;
        }
        if(mTemperature>=32){
            mTvTemperature.setText(String.format("%.1f°",mTemperature));
        }else if(mTemperature<=18){
            mTvTemperature.setText(String.format("%.1f°",mTemperature));
        }else{
            mTvTemperature.setText(String.format("%.1f°", mTemperature));
        }
    }

    private Runnable mRepeatedAction = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this, 100);

        }
    };



}