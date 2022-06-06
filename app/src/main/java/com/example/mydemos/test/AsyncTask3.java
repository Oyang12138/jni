package com.example.mydemos.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mydemos.R;

public class AsyncTask3 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private TextView textView;
    private ProgressBar progressBar;
    private MyAsyncTask3 myAsyncTask3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        textView = findViewById(R.id.text);
        progressBar = findViewById(R.id.pb);
        myAsyncTask3 = new MyAsyncTask3(textView,progressBar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAsyncTask3 = new MyAsyncTask3(textView,progressBar);
               myAsyncTask3.execute();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAsyncTask3.cancel(true);
            }
        });
    }

    public static class MyAsyncTask3 extends AsyncTask<String, Integer, String> {
        private TextView textView;
        private ProgressBar progressBar;

        public MyAsyncTask3(TextView textView, ProgressBar progressBar) {
            this.textView = textView;
            this.progressBar = progressBar;
        }

        @Override
        protected void onPreExecute() {
            textView.setText("加载中");
        }

        @Override
        protected String doInBackground(String... strings) {
            int count = 0;
            try {
                while (count < 99) {
                    count += 1;
                    publishProgress(count);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText("加载完毕！");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            textView.setText("loading...." + values[0] + "%");
        }

        @Override
        protected void onCancelled() {
            textView.setText("已取消");
            progressBar.setProgress(0);
        }
    }
}