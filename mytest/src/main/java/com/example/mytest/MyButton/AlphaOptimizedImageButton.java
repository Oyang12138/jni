package com.example.mytest.MyButton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint("AppCompatCustomView")
public class AlphaOptimizedImageButton extends ImageButton {
    public AlphaOptimizedImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean hasOverlappingRendering() {
        return super.hasOverlappingRendering();
    }
}
