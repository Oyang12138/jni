package com.example.mydemos.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mydemos.R;
import com.example.mydemos.text.Link;
import com.example.mydemos.text.LogTextBox;
import com.example.mydemos.text.Marquee;

public class TextMain extends AppCompatActivity{
    private Button link;
    private Button add;
    private Button marquee;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_main);
        link = findViewById(R.id.linkify);
        add = findViewById(R.id.logTextBox);
        marquee = findViewById(R.id.marquee);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent22 = new Intent(TextMain.this, LogTextBox.class);
                Log.i("TAG", "onClick: add被点击");
                startActivity(intent22);
            }
        });
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent11 = new Intent(TextMain.this, Link.class);
                Log.i("TAG", "onClick: link被点击");
                startActivity(intent11);
            }
        });

//        marquee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent33 = new Intent(TextMain.this, Marquee.class);
//                Log.i("TAG", "onClick: marquee被点击");
//                startActivity(intent33);
//            }
//        });

    }



//    @Override
//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.linkify:
//               intent = new Intent(TextMain.this, Link.class);
//                startActivity(intent);
//               break;
//            case R.id.logTextBox:
//                intent = new Intent(TextMain.this, LogTextBox.class);
//                startActivity(intent);
//                break;
//            case R.id.marquee:
//                intent = new Intent(TextMain.this, Marquee.class);
//                startActivity(intent);
//                break;
//        }
//
//    }

}