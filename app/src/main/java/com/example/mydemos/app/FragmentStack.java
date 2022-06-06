package com.example.mydemos.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.mydemos.R;

public class FragmentStack extends Activity {
    private Button push;
    private Button pop;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_stack);
        push = findViewById(R.id.push);
        pop = findViewById(R.id.pop);
        frameLayout = findViewById(R.id.fragment);

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "onClick: push");

                addStack();
//                MyFragment myFragment = new MyFragment();
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();;
//                fragmentTransaction.add(myFragment);
//
            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "onClick: pop");
                getFragmentManager().popBackStack(R.id.fragment, R.layout.activity_fragment_stack);
            }
        });

    }

    public void addStack() {
        Fragment newFrag = MyFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(R.id.fragment, newFrag);
        Log.i("TAG", "replace: replace");
        ft.commit();
    }

    @SuppressLint("ValidFragment")
    public static class MyFragment extends Fragment {
        static MyFragment newInstance() {
            MyFragment m = new MyFragment();
            return m;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.helloworld, container, false);
            return view;
        }
    }


}