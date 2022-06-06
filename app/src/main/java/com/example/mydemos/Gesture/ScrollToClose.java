package com.example.mydemos.Gesture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.mydemos.R;

public class ScrollToClose extends AppCompatActivity {
    private GestureDetector gestureDetector;
    private final static int MIN_MOVE = 200;
    private MyGestureListener myGestureListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_to_close);
        myGestureListener = new MyGestureListener();
        gestureDetector = new GestureDetector(ScrollToClose.this,myGestureListener);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
       @Override
       public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
           if(e1.getX() -e2.getX() >MIN_MOVE){
               startActivity(new Intent(ScrollToClose.this,MainActivity.class));
               Toast.makeText(ScrollToClose.this, "启动Activity", Toast.LENGTH_SHORT).show();

           }else{
               finish();
               Toast.makeText(ScrollToClose.this, "关闭Activity", Toast.LENGTH_SHORT).show();

           }

           return true;
       }
   }
}