package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.mytest.accountset.MyDialog;
import com.example.mytest.sqlite.MyAdapter;

import java.util.List;

public class ListViewTest extends AppCompatActivity {
private ListView listView;
private MyDialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        init();
        View convertView = View.inflate(ListViewTest.this,R.layout.activity_list_view_test,null);
        MyAdapter myAdapter = new MyAdapter(ListViewTest.this);
        listView.setAdapter(myAdapter);
        myDialog.setContentView(convertView);
        myDialog.setTitle("账户设置");
        Log.i("TAG", "onCreate: "+myDialog.getClass());
        myDialog.show();
        RelativeLayout account_set_container = (RelativeLayout) convertView.findViewById(R.id.account_set_container);
        account_set_container.setOnClickListener(vv -> {
            myDialog.dismiss();

        });


    }
    public void init(){
        myDialog = new MyDialog(ListViewTest.this);
        listView = findViewById(R.id.listview);
    }
}