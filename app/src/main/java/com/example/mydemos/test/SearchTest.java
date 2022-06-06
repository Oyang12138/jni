package com.example.mydemos.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.mydemos.R;

import java.util.ArrayList;

public class SearchTest extends Activity implements SearchView.OnQueryTextListener {
    private SearchView searchView;
    private ArrayList<String> arrayList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_test);
        listView = findViewById(R.id.list);
        searchView = findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchTest.this, android.R.layout.simple_list_item_1, new String[]{"aaa", "shfewnasdkj", "kjhdjiqwn", "wwwwww", "xsdcnw"});
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
        listView.setTextFilterEnabled(true);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if (!TextUtils.isEmpty(s)) {
            listView.setFilterText(s);
        } else {
            listView.clearTextFilter();
        }
        return false;
    }


}