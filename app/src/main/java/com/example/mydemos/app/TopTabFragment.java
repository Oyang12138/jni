package com.example.mydemos.app;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;


import com.example.mydemos.R;

public class TopTabFragment extends Fragment {
    private String content;

    public TopTabFragment() {
    }

    @SuppressLint("ValidFragment")
    public TopTabFragment(String content) {
        Log.i("TAG", "TopTabFragment: create");
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAG", "onCreateView: create Fragment");
        View view = inflater.inflate(R.layout.activity_fg_tabs_content,container,false);
        TextView textView = view.findViewById(R.id.txt_content);
        textView.setText(content);
        return view;
    }
}
