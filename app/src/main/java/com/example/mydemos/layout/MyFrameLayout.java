package com.example.mydemos.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mydemos.R;

public class MyFrameLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mylayout);
        MyFrame move = new MyFrame(MyFrameLayout.this);
        move.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                move.bitnmapX = motionEvent.getX()-150;
                move.bitmapY = motionEvent.getY() - 150;
                //调用重绘方法
                move.invalidate();
                return true;
            }
        });
        frameLayout.addView(move);
    }

}