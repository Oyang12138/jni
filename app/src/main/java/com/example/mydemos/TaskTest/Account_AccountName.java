package com.example.mydemos.TaskTest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mydemos.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account_AccountName extends AppCompatActivity {


    private ImageView accountButton;
    private TextView accountText;
    private ImageView headiconbutton;
    private TextView headText;
    private ListView listView;
    private SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_account_name);
        accountButton = findViewById(R.id.accountButton);
        listView = findViewById(R.id.list);
        headText = findViewById(R.id.headText);
        accountText = findViewById(R.id.accountText);

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this, "accountname.db", null, 1);
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues cvalues = new ContentValues();

        EditText editText = new EditText(Account_AccountName.this);
        editText.setHint("账号名");
        editText.setWidth(300);


        accountText.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Account_AccountName.this);
                alertDialog.setTitle("账号设置").setView(editText).setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        headText.setText(editText.getText());
                    }
                }).show();
            }
        });

        cvalues.put("accountname", editText.getText().toString());
        cvalues.put("flag", 1);
        db.insert("accountname.db", null, cvalues);
        db.close();
        //取
        db = myDatabaseHelper.getReadableDatabase();

        ArrayList<String> arrayList = query(db);
        for(int i = 0;i<arrayList.size();i++){
            Log.i("TAG", "arraylist: i"+arrayList.get(i));
        }

    }

    @SuppressLint("Range")
    public ArrayList<String> query(SQLiteDatabase sqLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();

        int flag;
        Cursor cursor = sqLiteDatabase.query("accountName.db", null, null, null, null, null, null);
        while (cursor.moveToNext()) {

           String x = cursor.getString(cursor.getColumnIndex("name"));
           arrayList.add(x);
        }
        return arrayList;
    }

    public class MyDatabaseHelper extends SQLiteOpenHelper {

        private Context context;
        public static final String CREATE_BOOK = "create table account ( "
                + " accountname text ,"
                + "flag integer default 0)";

        public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            this.context = context;
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_BOOK);
        }
        //打开数据库时传入的版本号与当前版本号不同时调用该方法
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }


}