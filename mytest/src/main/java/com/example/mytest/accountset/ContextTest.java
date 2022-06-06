package com.example.mytest.accountset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytest.R;

import java.util.HashMap;
import java.util.Map;

/**
 * AppCompatActivity:有顶部标题
 * Activity:没有顶部标题
 */
public class ContextTest extends AppCompatActivity {
    private EditText ed1;
    private EditText ed2;
    private View btn;
    private View btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_test);
        init();
        if(getValues()!=null){
            ed1.setText(getValues().get("name"));
            ed2.setText(getValues().get("pwd"));

        }
        SharedPreferences mSharedPreferences = getSharedPreferences("accountname",MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();

//        //隐藏标题栏
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("name",ed1.getText().toString());
                editor.putString("pwd",ed2.getText().toString());
                editor.commit();
                Toast.makeText(ContextTest.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clean();
            }
        });

    }

    public void init() {
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn = findViewById(R.id.btn11);
        btn2 = findViewById(R.id.btn2);
    }
    public Map<String,String> getValues(){
        Map<String,String> map = new HashMap<>();
        SharedPreferences sharedPreferences = getSharedPreferences("accountname",MODE_PRIVATE);

        map.put("name",sharedPreferences.getString("name",null));
        map.put("pwd",sharedPreferences.getString("pwd",null));
        return map;
    }
    public void clean(){
        SharedPreferences sharedPreferences = getSharedPreferences("accountname",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
    }
}