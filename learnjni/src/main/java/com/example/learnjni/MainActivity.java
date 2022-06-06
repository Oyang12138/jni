package com.example.learnjni;
/**
 * 1.创建类HelloJNI,定义native方法，引入静态库
 * 2.在java文件夹下javah -jni com.example.learnjni.HelloJNI（ 或javah -classpath . -jni com.example.learnjni.HelloJNI）,生成.h头文件
 * 3.将.h文件放在jni目录下，新建c/cpp文件，引入.h文件，实现方法
 * 4.调用类中方法
 */


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch aSwitch;
    private EditText editText;
        HelloJNI helloJNI = new HelloJNI();
//    MyTest myTest = new MyTest();
    ControlSwitch controlSwitch = new ControlSwitch();
    private Button btn;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        helloJNI.getString();
//        t1.setText(helloJNI.getString());
//        t1.setText(myTest.getString());
//        MyTest myTest = new MyTest();
//        t1.setText(myTest.WifiButton());
        //c调java 模拟开关
//        t1 = findViewById(R.id.t1);
        editText = findViewById(R.id.ed1);
        btn = findViewById(R.id.btn);
        aSwitch = findViewById(R.id.sw1);
        editText = findViewById(R.id.ed1);
        editText.setText(String.valueOf(controlSwitch.getSwitchStatus()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(editText.getText().toString()) ==1){
                    aSwitch.setChecked(true);
                }else{
                    aSwitch.setChecked(false);
                }
            }
        });


    }
}