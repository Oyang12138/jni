package com.example.mydemos.Gesture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.mydemos.R;

public class MainActivity extends AppCompatActivity {
    private GestureDetector gestureDetector;
    private MyGestureListener myGestureListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myGestureListener = new MyGestureListener();
        gestureDetector = new GestureDetector(this,myGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener implements GestureDetector.OnGestureListener{
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.i("TAG", "onDown: 按下");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.i("TAG", "onShowPress: 手指按下一段时间，没到长按");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.i("TAG", "onSingleTapUp: 手指离开一瞬间");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i("TAG", "onScroll: 触摸屏上划");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.i("TAG", "onLongPress: 长按且没松开");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i("TAG", "onFling: 迅速滑动并松开");
            return false;
        }
    }
}