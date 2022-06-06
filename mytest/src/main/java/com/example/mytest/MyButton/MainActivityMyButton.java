package com.example.mytest.MyButton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mytest.ListViewTest;
import com.example.mytest.R;
import com.example.mytest.sqlite.MyAdapter;

public class MainActivityMyButton extends AppCompatActivity implements View.OnClickListener{
    private AlphaOptimizedImageButton icon;
    private Button add;
    private Button add1;
    private Button btn3;
    private AlertDialog alertDialog = null;
    private AlertDialog.Builder builder;
    private Window window;
    private LinearLayout layout;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mybutton);
        initView();
        context = MainActivityMyButton.this;
//        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.);
    }

    @SuppressLint("ResourceType")
    public void initView() {
        icon = findViewById(R.id.car_nav_button_icon);
        add = findViewById(R.id.add);
        add1 = findViewById(R.id.add1);
        btn3 = findViewById(R.id.btn3);
        layout = findViewById(R.id.layout);
        builder = new AlertDialog.Builder(MainActivityMyButton.this);
        add.setOnClickListener(this);
        add1.setOnClickListener(this);
        btn3.setOnClickListener(this);
        layout.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
                alertDialog = builder.setIcon(R.drawable.ic_baseline_account_box_24).setTitle("账户设置111").create();
                window = alertDialog.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();
                alertDialog.getWindow().setLayout(200, 100);
                Log.i("TAG", "onClick: 111"+alertDialog.getClass());
                break;
            case R.id.add1:

                alertDialog = builder.setIcon(R.drawable.ic_baseline_account_box_24).setTitle("账户设置222").create();
                alertDialog.getWindow().setDimAmount(0f);
                alertDialog.setCanceledOnTouchOutside(true);
                window = alertDialog.getWindow();
//                window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
                alertDialog.show();
                alertDialog.getWindow().setLayout(400, 400);
                Log.i("TAG", "onClick: 222"+alertDialog.getClass());
                break;
            case R.id.btn3:
                LayoutInflater layoutInflater = this.getLayoutInflater();
                View v = layoutInflater.inflate(R.layout.activity_list_view_test,null);
                alertDialog = builder.setTitle("333").setView(v).create();



                alertDialog.show();

                Log.i("TAG", "onClick: "+333);
                break;
            default:
                Log.i("TAG", "onClick: 444");
                alertDialog.dismiss();
                return;
        }

    }
}