package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogTest extends AppCompatActivity implements View.OnClickListener{
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private Context mContext;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);
        mContext = DialogTest.this;
        init();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn1:
                alert = null;
                alert.setCanceledOnTouchOutside(true);
                builder = new AlertDialog.Builder(mContext);
                builder = builder.setIcon(R.drawable.ic_baseline_account_box_24).setTitle("dialog1");
                builder.setMessage("这是btn1对话框内容");
                alert= builder.create();
                alert.show();
                break;
            case R.id.btn2:
                alert = null;

                builder = new AlertDialog.Builder(mContext);
                builder = builder.setIcon(R.drawable.ic_baseline_account_box_24).setTitle("dialog2");
                builder.setMessage("这是btn2对话框内容");
                alert.show();
                break;
            case R.id.btn3:
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                builder = builder.setIcon(R.drawable.ic_baseline_account_box_24).setTitle("dialog3");
                builder.setMessage("这是btn3对话框内容");
                alert = builder.create();
                alert.show();
        }
    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }
    public AlertDialog.Builder create(){
        builder = new AlertDialog.Builder(mContext);
        return builder;
    }
}