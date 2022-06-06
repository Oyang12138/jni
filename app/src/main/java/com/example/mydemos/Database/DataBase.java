package com.example.mydemos.Database;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydemos.R;

public class DataBase extends AppCompatActivity {
    private MyDataBase myDataBase;
    private EditText textView;
    private Button button;
    private TextView text2;
    private String name;
    private ListView listView;
    private Button save;
    private Button intentBtn;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        init();
        MyAdapter myAdapter = new MyAdapter(this);
        Log.i("TAG", "onCreate: ");
        listView.setAdapter(myAdapter);
        SharedPreferences sharedPreferences = getSharedPreferences("accountName", MODE_PRIVATE);
        int po = sharedPreferences.getInt("position", 0);
        myAdapter.setSelectPosition(po);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DataBase.this, "111", Toast.LENGTH_SHORT).show();
//                button2.setText(getCurrentName());
                Log.i("TAG", "onClick: " + save.getText().toString());


            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("ResourceType") View view1 = View.inflate(DataBase.this, R.layout.activity_data_base, null);
                Button button = view1.findViewById(R.id.save);
                Log.i("TAG", "onClickbtn1: " + button.getText());
                button.setText("22");
                Log.i("TAG", "onClickbtn2: " + button.getText());
                save.setText("222");
                Log.i("TAG", "onClicksave: " + save.getText());

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                myAdapter.setSelectPosition(position);
                LinearLayout layout = (LinearLayout) listView.getChildAt(position);
                TextView textView = layout.findViewById(R.id.text);
                ImageView imageView = layout.findViewById(R.id.icon);
                Log.i("TAG", "onItemClick: " + position);

                SharedPreferences sharedPreferences = getSharedPreferences("accountName", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", textView.getText().toString());
                editor.putInt("position", position);
                editor.commit();
//myDataBase = new MyDataBase(DataBase.this, "accountname", null, 1);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                name = textView.getText().toString();
//                SQLiteDatabase dbwrite = myDataBase.getWritableDatabase();
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("name", name);
//                dbwrite.insert("accountname", null, contentValues);
//                dbwrite.close();
//                Log.i("TAG", "onClick: 提交成功");
//
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SQLiteDatabase dbRead = myDataBase.getReadableDatabase();
//                query(dbRead);
//              ;
//            }

            }
        });
    }

    public void init() {
        textView = findViewById(R.id.text);
        button = findViewById(R.id.btn);
        text2 = findViewById(R.id.text2);
        listView = findViewById(R.id.list);
        intentBtn = findViewById(R.id.intent);
        save = findViewById(R.id.save);

    }
//
//    public String[] getData(MyDataBase m) {
//        SQLiteDatabase dbRead = m.getReadableDatabase();
//
//        return query(dbRead);
//    }

//    //查询账户数据库内容
//    @SuppressLint("Range")
//    public String[] query(SQLiteDatabase dbRead) {
//        ArrayList<String> arrayList = new ArrayList<>();
//
//        Cursor cursor = dbRead.query("accountname", null, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            arrayList.add(cursor.getString(cursor.getColumnIndex("name")));
//        }
//
//        String[] strings = new String[arrayList.size()];
//        for (int i = 0, j = arrayList.size(); i < j; i++) {
//            strings[i] = arrayList.get(i);
//        }
//        return strings;
//    }
//
//    public void query(SQLiteDatabase dbRead) {
//        Cursor cursor = dbRead.query("accountname", null, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
//            Log.i("TAG", "query: name"+name);
//        }
//    }
//    public void delete(SQLiteDatabase dbRead){
//        dbRead.update("accountname",)
//    }

    public String getCurrentName() {
        SharedPreferences userInfo = getSharedPreferences("accountName", MODE_PRIVATE);
        return userInfo.getString("name", "小雅");
    }


}
