package com.example.mydemos.text;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.example.mydemos.R;

public class Link extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        //text1:autoLink,自动识别电话邮箱网址
        TextView t2 = findViewById(R.id.text2);
        //移动方式：链接
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        //滚动条
        //t2.setMovementMethod(ScrollingMovementMethod.getInstance());
        TextView t3 = findViewById(R.id.text3);
        t3.setText(
                Html.fromHtml(
                        "<b>text3: Constructed from HTML programmatically.</b>  Text with a " +
                                "<a href=\"http://www.google.com\">link</a> " +
                                "created in the Java source code using HTML."));
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        //string
        SpannableString ss = new SpannableString("text4: Manually created spans. Click here to dial the phone.");
        //文字样式：（样式，开始，结束，前后都不包括）
        ss.setSpan(new StyleSpan(Typeface.BOLD),0,30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //链接
        ss.setSpan(new URLSpan("tel:1654321543"),31+6,31+10,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        TextView t4 = findViewById(R.id.text4);
        t4.setText(ss);
        t4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView t5 = findViewById(R.id.text5);
    }
}