package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MyFragment extends AppCompatActivity implements View.OnClickListener {
    private TextView txt_topbar;
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    private SelfFragment f1,f2,f3,f4;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        fragmentManager = getFragmentManager();
        bindViews();
        txt_channel.performClick();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_channel:
                setSelected();
                txt_channel.setSelected(true);
                if(f1 == null){
                    f1 = new SelfFragment("第一个Fragment");
                    fTransaction.add(R.id.ly_content,f1);
                }else{
                    fTransaction.show(f1);
                }
                break;
            case R.id.txt_message:
                setSelected();
                txt_message.setSelected(true);
                if(f2 == null){
                    f2 = new SelfFragment("第二个Fragment");
                    fTransaction.add(R.id.ly_content,f2);
                }else{
                    fTransaction.show(f2);
                }
                break;
            case R.id.txt_better:
                setSelected();
                txt_better.setSelected(true);
                if(f3 == null){
                    f3 = new SelfFragment("第三个Fragment");
                    fTransaction.add(R.id.ly_content,f3);
                }else{
                    fTransaction.show(f3);
                }
                break;
            case R.id.txt_setting:
                setSelected();
                txt_setting.setSelected(true);
                if(f4 == null){
                    f4 = new SelfFragment("第四个Fragment");
                    fTransaction.add(R.id.ly_content,f4);
                }else{
                    fTransaction.show(f4);
                }
                break;
        }
        fTransaction.commit();

    }
    private void setSelected(){
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }
    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(f1 != null)fragmentTransaction.hide(f1);
        if(f2 != null)fragmentTransaction.hide(f2);
        if(f3 != null)fragmentTransaction.hide(f3);
        if(f4 != null)fragmentTransaction.hide(f4);

    }
}