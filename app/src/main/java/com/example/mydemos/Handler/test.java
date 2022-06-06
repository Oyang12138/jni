package com.example.mydemos.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemos.R;

public class test extends AppCompatActivity {
    private Button button;
    private ChilderThread1 childerThread1;
//    private ChildThread2 childerThread2;
    private Handler MainThread;
    private Button button2;
    private TextView textView1;
    private TextView textView2;
    private Handler mainHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //主线程handler,可以UI操作
            /**
             *主线程获取到msg.what==2发来的message
             */
            if(msg.what == 1){
                String str = (String) msg.obj;

                textView2.setText("mainHandler Send Message");
                Toast.makeText(test.this, "主线程收到Click2的消息2"+str, Toast.LENGTH_SHORT).show();
            }else if(msg.what ==0){
                textView1.setText("chilThread send Message");


            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btn2);
        textView1 = findViewById(R.id.tv1_1);
        textView2 = findViewById(R.id.tv2_2);
        childerThread1 = new ChilderThread1();
        childerThread1.start();
//        childerThread2 = new ChildThread2();
//        childerThread2.start();


    }

    public void onClick(View view) {
        //begin
        Message childmessage = new Message();
        childmessage.what = 0;
        Bundle bundle = new Bundle();
        bundle.putInt("key", 22);
        childmessage.setData(bundle);
        //发送
        childerThread1.c2handler.sendMessage(childmessage);
        Log.i("TAG", "onClick: childmessage子线程handler发送消息 what = 0");
        //end
        //begin
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message mainMessage = new Message();
                mainMessage.what = 1;
                mainMessage.obj = "mainMessage-mainHandler";
                //用主线程的handler给主线程发送消息
                mainHandler.sendMessage(mainMessage);
            }
        }.start();
        Toast.makeText(test.this, "new Thread发送消息子线程1", Toast.LENGTH_SHORT).show();

    }

    /**
     * 主线程的handler给主线程发消息
     * @param view
     */
    public void onClick2(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message mainMessage = new Message();
                mainMessage.what = 1;
                mainMessage.obj = "mainMessage-mainHandler";
                //用主线程的handler给主线程发送消息
                mainHandler.sendMessage(mainMessage);


            }
        }.start();
        Toast.makeText(test.this, "new Thread发送消息子线程1", Toast.LENGTH_SHORT).show();
    }




    //子线程1
    class ChilderThread1 extends Thread {
        public Handler c2handler;

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            c2handler = new Handler() {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0) {
                        Toast.makeText(test.this, "000"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
                        Message message = new Message();
                    }
                    if(msg.what ==1){
                        Toast.makeText(test.this, "22222"+ Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            Looper.loop();
        }
    }
//    class ChildThread2 extends Thread{
//        public Handler handler;
//
//        @Override
//        public void run() {
//            super.run();
//            Looper.loop();
//            handler = new Handler(){
//                @Override
//                public void handleMessage(@NonNull Message msg) {
//                    super.handleMessage(msg);
//                    if(msg.what == 2){
//                        Toast.makeText(test.this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
//                    }
//                    else if(msg.what == 0){
//                        Toast.makeText(test.this, "来自字线程1", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            };
//            Looper.loop();
//        }
//    }
}