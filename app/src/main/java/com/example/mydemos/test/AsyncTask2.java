package com.example.mydemos.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemos.R;

public class AsyncTask2 extends AppCompatActivity {
    private TextView textView;
    private ProgressBar progressBar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task2);
        textView = findViewById(R.id.tv1);
        progressBar = findViewById(R.id.pb);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 创建实例和execute方法在UI线程
                 */
                MyAsyncTask myAsyncTask = new MyAsyncTask(textView,progressBar);
                myAsyncTask.execute(1000);
            }
        });
        Toast.makeText(this, "MainUi", Toast.LENGTH_SHORT).show();
    }

    /**
     * 延时操作，模拟下载
     */
    public static class DelayOperator{
        public void delay(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 自定义AsyncTask
     */
    public class MyAsyncTask extends AsyncTask<Integer,Integer,String>{
        private TextView txt;
        private ProgressBar pb;

        public MyAsyncTask(TextView txt, ProgressBar pb) {
            this.txt = txt;
            this.pb = pb;
        }
        /**
         * 运行在UI线程，可对控件操作，初始化操作
         */
        @Override
        protected void onPreExecute() {

            txt.setText("开始异步线程");
            Log.i("TAG", "onPreExecute: ");

        }

        /**
         * 不运行在UI线程，用于异步操作，调用publishProgress()触发onProgressUpdate对UI操作
         * @param integers
         * @return
         */
        @Override
        protected String doInBackground(Integer... integers) {
            Log.i("TAG", "doInBackground: ");
            DelayOperator delayOperator = new DelayOperator();
            int i = 0;
            for(i=0 ;i<=100;i+=10){
                delayOperator.delay();
                Log.i("TAG", "doInBackground: "+i);
                publishProgress(i);
            }

            return i+integers[0].intValue()+"";
        }
        /**
         * 在doInBackGround -> publishProgress(i);后调用,运行在UI线程
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i("TAG", "onProgressUpdate: ");
            int value = values[0];
            pb.setProgress(value);
        }

        /**
         * 计算结果传递给UI线程
         * @param s
         */
        @Override
        protected void onPostExecute(String s) {
            Log.i("TAG", "onPostExecute: ");
            super.onPostExecute(s);
        }


    }
}