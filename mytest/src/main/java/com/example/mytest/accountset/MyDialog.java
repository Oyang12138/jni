package com.example.mytest.accountset;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mytest.R;

public class MyDialog extends Dialog {
    private ImageView mIconDismiss;
    TextView mTitle;
    LinearLayout mContentContainer;
    RelativeLayout mHeaderContainer;
    Button mButtonFirst;
    Button mButtonSecond;
    Space mCenterSpaceOfButton;

    public MyDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public MyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    public MyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void init(){
        setContentView(R.layout.activity_dialog_base);
        mIconDismiss = findViewById(R.id.icon_dismiss);
        mIconDismiss.setOnClickListener(v -> this.dismiss());
        mTitle = findViewById(R.id.dialog_title);
        mTitle.setText("账户设置");
        mButtonFirst = findViewById(R.id.dialog_first);
    }
    public void setCenterView(View view) {
        mContentContainer.removeAllViews();
        mContentContainer.addView(view);
    }
    public void setupTitleAndListener(String text, View.OnClickListener listener){
        mTitle.setText(text);
        mTitle.setOnClickListener(listener);
    }
}
