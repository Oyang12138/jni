package com.example.mydemos.app;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import android.widget.TextView;

import com.example.mydemos.R;



public class Tabs extends AppCompatActivity implements View.OnClickListener {
    private TextView view1;
    private TextView view2;
    private TextView view3;
    private TextView view4;
    private FrameLayout frameLayout;
    private TopTabFragment f1, f2, f3, f4;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        fragmentManager = getFragmentManager();
        bindViews();
        view1.performLongClick();


    }
    private void bindViews(){
        Log.i("TAG", "bindViews: 绑定");
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        frameLayout = findViewById(R.id.ly_content);

        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
    }
    //设置选中状态为false
    private void settSelected() {
        Log.i("TAG", "settSelected: 清空选中状态");
        view1.setSelected(false);
        view2.setSelected(false);
        view3.setSelected(false);
        view4.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        Log.i("TAG", "hideAllFragment: 隐藏");
        if (f1 != null) {
            fragmentTransaction.hide(f1);
        }
        if (f2 != null) {
            fragmentTransaction.hide(f2);
        }
        if (f3 != null) {
            fragmentTransaction.hide(f3);
        }
        if (f4 != null) {
            fragmentTransaction.hide(f4);
        }

    }

    @Override
    public void onClick(View view) {
        Log.i("TAG", "onClick: "+view.getId());
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (view.getId()) {
            case R.id.view1:
                settSelected();
                view1.setSelected(true);
                if(f1 == null){
                    f1 = new TopTabFragment("第一个Fragment");

                    fragmentTransaction.add(R.id.ly_content,f1);
                }else{
                    fragmentTransaction.show(f1);
                }
                break;
            case R.id.view2:
                settSelected();
                view2.setSelected(true);
                if(f2 == null){
                    f2= new TopTabFragment("第二个Fragment");
                    fragmentTransaction.add(R.id.ly_content,f2);
                }else{
                    fragmentTransaction.show(f2);
                }
                break;
            case R.id.view3:
                settSelected();
                view3.setSelected(true);
                if(f3 == null){
                    f3 = new TopTabFragment("第三个Fragment");
                    fragmentTransaction.add(R.id.ly_content,f3);
                }else{
                    fragmentTransaction.show(f3);
                }
                break;
            case R.id.view4:
                settSelected();
                view4.setSelected(true);
                if(f4 == null){
                    f4 = new TopTabFragment("第四个Fragment");
                    fragmentTransaction.add(R.id.ly_content,f4);
                }else{
                    fragmentTransaction.show(f4);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}