package com.example.mytest.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mytest.R;

import java.util.List;

public class SqliteTest extends AppCompatActivity implements View.OnClickListener {
    private Button insert;
    private Button delete;
    private Button queryOne;
    private Button queryAll;
    private EditText name;
    private EditText pwd;
    private SQLiteDatabase db;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private StringBuilder stringBuilder;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_test);
        init();
        sqLiteOpenHelper = new MySQLite(SqliteTest.this, "accountname.db", null, 1);
        View convertView = View.inflate(SqliteTest.this,R.layout.activity_sqlite_test,null);
//        LinearLayout content_area = convertView.findViewById(R.id.content_area);
        MyAdapter myAdapter = new MyAdapter(SqliteTest.this);
        listView.setAdapter(myAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(SqliteTest.this, i+"被点击", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void init() {
        insert = findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        queryOne = findViewById(R.id.queryone);
        queryAll = findViewById(R.id.queryAll);
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);
        queryAll = findViewById(R.id.queryAll);
        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        queryOne.setOnClickListener(this);
        queryAll.setOnClickListener(this);
        listView = findViewById(R.id.list);
    }

    @Override
    public void onClick(View view) {
        db = sqLiteOpenHelper.getWritableDatabase();
        stringBuilder = new StringBuilder();
        switch (view.getId()) {
            case R.id.insert:
                ContentValues values1 = new ContentValues();
                values1.put("accountname", name.getText().toString());
                values1.put("accountpwd", pwd.getText().toString());
                db.insert("accountname", null, values1);
                Toast.makeText(SqliteTest.this, "插入成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                db.delete("accountname", "accountid = ?", new String[]{"1"});
                Toast.makeText(SqliteTest.this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.queryAll:
                Cursor cursor = db.query("accountname", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        @SuppressLint("Range") int pid = cursor.getInt(cursor.getColumnIndex("accountid"));
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("accountname"));
                        @SuppressLint("Range") String pwd = cursor.getString(cursor.getColumnIndex("accountpwd"));
                        stringBuilder.append("id" + pid + ":" + name + "-" + pwd + "\n");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                Toast.makeText(SqliteTest.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.queryone:
                //条件查询
                Cursor cursor1 = db.query("accountname", null, "accountname=? and accountpwd = ?", new String[]{"tom", "123456"}, null, null, null);
                if (cursor1.moveToFirst()) {
                    do {
                        @SuppressLint("Range") int pid = cursor1.getInt(cursor1.getColumnIndex("accountid"));
                        @SuppressLint("Range") String name = cursor1.getString(cursor1.getColumnIndex("accountname"));
                        @SuppressLint("Range") String pwd = cursor1.getString(cursor1.getColumnIndex("accountpwd"));
                        stringBuilder.append("id" + pid + ":" + name + "-" + pwd + "\n");
                    } while (cursor1.moveToNext());
                }
                cursor1.close();
                Toast.makeText(SqliteTest.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /**
     * sql操作
     */
    //插入
    private void insert() {
        db = sqLiteOpenHelper.getWritableDatabase();
        db.execSQL("insert into accountname(accountname,accountpwd) values(?,?)", new String[]{name.getText().toString(), pwd.getText().toString()});
    }
    //查询
    private void query() {
        db = sqLiteOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from accountname where accountname =?", new String[]{"tom"});
        @SuppressLint("Range") int pid = cursor.getInt(cursor.getColumnIndex("accountid"));
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("accountname"));
        @SuppressLint("Range") String pwd = cursor.getString(cursor.getColumnIndex("accountpwd"));
        Toast.makeText(SqliteTest.this, "id" + pid + ":" + name + "-" + pwd + "\n", Toast.LENGTH_SHORT).show();
        cursor.close();
    }
    //条件查询
    private void queryOne() {
        db = sqLiteOpenHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select accountname,accountpwd from accountname where accountname = ?", new String[]{"tom"});
        @SuppressLint("Range") int pid = cursor.getInt(cursor.getColumnIndex("accountid"));
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("accountname"));
        @SuppressLint("Range") String pwd = cursor.getString(cursor.getColumnIndex("accountpwd"));
        Toast.makeText(SqliteTest.this, "id" + pid + ":" + name + "-" + pwd + "\n", Toast.LENGTH_SHORT).show();
        cursor.close();
    }
    //更新操作
    private void update() {
        db = sqLiteOpenHelper.getWritableDatabase();
        db.execSQL("update accountname set accountpwd=? where accountid = ?", new String[]{"55555","1"});
    }
    //删除
    private void delete() {
        db = sqLiteOpenHelper.getWritableDatabase();
        db.execSQL("delete from accountname where accountid = ?",new String[]{"2"});
    }


}