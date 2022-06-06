package com.example.mydemos.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.example.mydemos.R;

import java.util.Timer;
import java.util.TimerTask;

public class HandlerTest extends Activity {
   private ImageView imageView ;
    int imgids[] = new int[]{
            R.drawable.ic_baseline_3d_rotation_24,R.drawable.ic_baseline_brightness_4_24
            ,R.drawable.ic_baseline_person_add_alt_1_24,R.drawable.abc_vector_test
    };
    int start = 0;
    /**
     * handler在主线程，系统已经初始化了一个Looper对象，直接创建Handler对象
     * 定时帧动画
     */
    final Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 0){
                imageView.setImageResource(imgids[start++ %4]);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        imageView = findViewById(R.id.img);
        //每隔200ms发一条空消息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },0,2000);


    }
}