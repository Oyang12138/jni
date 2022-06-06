package com.example.mytest;

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

import java.util.ArrayList;

public class ListViewSearch extends Activity implements SearchView.OnQueryTextListener {
    private SearchView searchView;
    private  ArrayList<String> arrayList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_search);
        listView = findViewById(R.id.list);
        searchView = findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewSearch.this, android.R.layout.simple_list_item_1,new String[]{"aaa","shfewnasdkj","kjhdjiqwn","wwwwww","xsdcnw"});
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
        if(!TextUtils.isEmpty(s)){
            listView.setFilterText(s);
        }else{
            listView.clearTextFilter();
        }
        return false;
    }



}