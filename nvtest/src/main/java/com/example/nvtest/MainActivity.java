package com.example.nvtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private AlertDialog dialog;
private Context context;
private Button button;
private Button save;
private Button cancel;
private EditText pattern;
private EditText strength;
private AlertDialog alertDialog;
private AlertDialog.Builder alertBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.www);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(context).inflate(R.layout.activity_main,null,false);
                dialog = new AlertDialog.Builder(context).setView(view).setCancelable(true).create();
                initDialog(view);
                dialog.show();
            }
        });
        context = this;

    }
    public void initDialog(View view){
        pattern = view.findViewById(R.id.pattern);
        strength = view.findViewById(R.id.strength);
        save = view.findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x,y;
                if(!pattern.getText().equals("") || !strength.getText().equals("")){
                    try {
                        x = Integer.parseInt(pattern.getText().toString());
                        y = Integer.parseInt(strength.getText().toString());
                        if(x>123 || x<1){
                        }else{

                        }
                        if(y>255 || y<0){

                        }else{

                        }
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(context, "null", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cancel = view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public void initDialog2(){
        alertBuilder = new AlertDialog.Builder(context).setTitle("");
    }

}