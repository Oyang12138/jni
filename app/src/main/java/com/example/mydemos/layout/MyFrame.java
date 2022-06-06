package com.example.mydemos.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.mydemos.R;

public class MyFrame extends View {
    public float bitnmapX;
    public float bitmapY;

    public MyFrame(Context context) {
        super(context);
        bitnmapX = 0;
        bitmapY = 150;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint();
        Bitmap mBitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.s_1);
        canvas.drawBitmap(mBitmap, bitnmapX, bitmapY, mPaint);
        if (mBitmap.isRecycled()) {
            mBitmap.recycle();
        }
    }
}
