package com.example.mytest.accountset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytest.R;

public class AccountSetTest extends AppCompatActivity {
    private Button dialog_button;
    private MyDialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_set_test);
        init();
        dialog_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog = new MyDialog(AccountSetTest.this);
                myDialog.mTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccountSetTest.this,ContextTest.class);
                        startActivity(intent);
                    }
                });
                myDialog.show();
            }
        });
    }
    public void init(){
        dialog_button = findViewById(R.id.dialog_button);
//        myDialog = new MyDialog(AccountSetTest.this);
    }



}
