package com.example.test;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StatusDialog extends Dialog {

    public StatusDialog(@NonNull Context context) {
        super(context);
    }

    public StatusDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public StatusDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public boolean isShowing() {
        Log.i("TAG", "isShowing: ");
        return super.isShowing();
    }

    @Override
    public void create() {
        super.create();
    }

    @Override
    public void show() {
        Log.i("TAG", "show: ");
        Log.i("TAG", "show: ");
        Log.i("TAG", "show: ");
    }

    @Override
    public void hide() {
        Log.i("TAG", "hide: ");

    }

    @Override
    public void dismiss() {
        Log.i("TAG", "dismiss: ");
    }
}
