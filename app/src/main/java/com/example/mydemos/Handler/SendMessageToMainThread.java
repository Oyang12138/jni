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
import android.widget.Toast;

import com.example.mydemos.R;

public class SendMessageToMainThread extends AppCompatActivity {
    private Button miantomain;
    private Button childtomain;
    private Button childtochild;
    private Button maintochild;
    private Message message1 ;
    private Message message2 ;
    private Message message3 ;
    private Message message4 ;
    private ChildThread childThread;

    public Handler mianhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                Toast.makeText(SendMessageToMainThread.this, "收到主线程发送的msg"+msg.getData().getString("str1"), Toast.LENGTH_SHORT).show();
            }
            if(msg.what == 2){
                Toast.makeText(SendMessageToMainThread.this, "收到子线程发送的msg"+msg.getData().getString("str2"), Toast.LENGTH_SHORT).show();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message_to_main_thread);
        miantomain = findViewById(R.id.btn1);
        childtomain= findViewById(R.id.btn2);
        childtochild = findViewById(R.id.btn3);
        maintochild = findViewById(R.id.btn4);
        childThread = new ChildThread();
        childThread.start();

    }



    class ChildThread extends Thread{
        public Handler childHandler;
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            childHandler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    if(msg.what == 3){
                        //空
                        Log.i("TAG", "handleMessage: "+msg.getData().getString("str"));
                        Toast.makeText(SendMessageToMainThread.this, "收到来自子线程的msg"+msg.getData().getString("str3"), Toast.LENGTH_SHORT).show();
                    }
                    if(msg.what == 4){
                        //空
                        Log.i("TAG", "handleMessage: "+msg.getData().getString("str"));
                        Toast.makeText(SendMessageToMainThread.this, "收到来自子线程的msg"+msg.getData().getString("str4"), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            Looper.loop();

        }
    }

    public void MainToMain(View view) {
        message1 = new Message();
        message1.what = 1;
        Bundle bundle1 = new Bundle();
        bundle1.putString("str1","from main handler");
        message1.setData(bundle1);
        message1.obj = "message1 from main";
        mianhandler.sendMessage(message1);
    }

    public void ChildToMain(View view) {

        message2 = new Message();
        message2.what = 2;
        Bundle bundle2 = new Bundle();
        bundle2.putString("str2","from childtomain");
        message2.setData(bundle2);
        new Thread(){
            @Override
            public void run() {
                mianhandler.sendMessage(message2);
            }
        }.start();
    }

    /**
     * 空
     * @param view
     */
    public void ChildToChild(View view) {
        message3 = new Message();
        message3.what = 3;
        Bundle bundle3 = new Bundle();
        bundle3.putString("str3","from childHandler");
        new Thread(){
            @Override
            public void run() {
                childThread.childHandler.sendMessage(message3);

            }
        }.start();

    }
    public void MainToChild(View view) {

        Bundle bundle4 = new Bundle();

        bundle4.putString("str4","from miantochild");
        message4 = new Message();
        message4.what=4;
        message4.setData(bundle4);
        childThread.childHandler.sendMessage(message4);
    }
}