package com.example.mydemos.text;

import android.content.Context;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LogTextBox1 extends androidx.appcompat.widget.AppCompatTextView {
    public LogTextBox1(Context context) {
        super(context);
    }

    public LogTextBox1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LogTextBox1(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //默认移动方法
    @Override
    protected MovementMethod getDefaultMovementMethod() {
        return ScrollingMovementMethod.getInstance();
    }

    @Override
    public CharSequence getText() {
        return super.getText();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }
}
