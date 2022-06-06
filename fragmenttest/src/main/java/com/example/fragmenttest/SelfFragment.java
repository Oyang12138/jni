package com.example.fragmenttest;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


@SuppressLint("ValidFragment")
public class SelfFragment extends Fragment {
    private String content;
    public SelfFragment(String content){
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_context = (TextView) view.findViewById(R.id.txt_context);
        txt_context.setText(content);
        Log.i("TAG", "onCreateView: "+content);

        return view;
    }
}
