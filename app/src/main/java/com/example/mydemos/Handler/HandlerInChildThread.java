package com.example.mydemos.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydemos.R;

import java.util.ArrayList;
import java.util.List;

public class HandlerInChildThread extends AppCompatActivity {
    EditText text;
    static final String UPPER_NUM = "upper";
    CalThread calThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_in_child_thread);
        text = findViewById(R.id.edit);
        calThread = new CalThread();
        calThread.start();
    }
    //按钮点击事件
    public void cal(View view) {
        //创建消息
        Message message = new Message();
        message.what = 0;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM,Integer.parseInt(text.getText().toString()));
        message.setData(bundle);
        //向新线程Handler发送消息
        calThread.handler.sendMessage(message);
    }
    //线程类
    class CalThread extends Thread{
        public Handler handler;

        @Override
        public void run() {
            /**
             * 为子线程创建Looper对象
             */
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    if(msg.what == 0){
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<Integer>();
                        outer:
                        for(int i = 2;i<=upper;i++){
                            for(int j= 2;j<= Math.sqrt(i);j++){
                                if(i!=2&&i%j==0){
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        Toast.makeText(HandlerInChildThread.this, nums.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            //启动looper
            Looper.loop();
        }
    }
}