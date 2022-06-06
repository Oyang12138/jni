package com.example.mydemos.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemos.R;

public class AsyncTaskTest extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        textView = findViewById(R.id.textasync);

        Toast.makeText(AsyncTaskTest.this, textView.getText(), Toast.LENGTH_SHORT).show();
        Log.i("TAG", "onCreate: 子线程");
//子线程
        new Thread(){
            public void run(){
                Log.i("TAG", "run: 子线程执行");
                try {
                    textView.setText(timeOutTest());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Log.i("TAG", "onCreate: 子线程end");
        Toast.makeText(AsyncTaskTest.this, textView.getText(), Toast.LENGTH_SHORT).show();


    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
    public String timeOutTest() throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1;i<100 ;i++){
            stringBuffer.append("第"+i+"个数");
        }
        String result = stringBuffer.toString();
        Log.i("TAG", "timeOutTest: 开始计时"+System.currentTimeMillis());
        Thread.sleep(15000);
        Log.i("TAG", "timeOutTest: 结束"+System.currentTimeMillis());
        return result;
    }
}