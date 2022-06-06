package com.example.mydemos.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.mydemos.R;

import java.util.Calendar;

/**
 * 日期部件  android.app.TimePickerDialog,android.widget.DatePicker
 */
public class DateWidgets1 extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView textView;
    private int mYear;
    private int mMonth;
    private int mHour;
    private int mMinute;
    private int mday;
    static final int TIME_12_DIALOG_ID = 0;
    static final int TIME_24_DIALOG_ID = 1;
    static final int DATE_DIALOG_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_widgets1);
        textView = findViewById(R.id.textview);
        setDialogOnClickListener(R.id.btn1, DATE_DIALOG_ID);
        setDialogOnClickListener(R.id.btn2, TIME_12_DIALOG_ID);
        setDialogOnClickListener(R.id.btn3, TIME_24_DIALOG_ID);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mday = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        updateDisplay();
    }
//保持和上次一样
    @Override
    protected Dialog onCreateDialog(int id) {
        Log.i("TAG", "onCreateDialog: CreateDialog回调");
        switch (id) {
            case TIME_12_DIALOG_ID:
            case TIME_24_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener,
                        mHour, mMinute,id == TIME_24_DIALOG_ID);
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDataSetListener,
                        mYear, mMonth, mday);
        }
        return null;
    }
//改变属性
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        Log.i("TAG", "onPrepareDialog: 每次弹出对话框回调"+id);
        switch (id){
            case TIME_12_DIALOG_ID:
            case TIME_24_DIALOG_ID:
                ((TimePickerDialog) dialog).updateTime(mHour,mMinute);
                break;
            case DATE_DIALOG_ID:
                ((DatePickerDialog) dialog).updateDate( mYear, mMonth, mday);
                break;

        }
    }

    //更新时间
    private void updateDisplay() {
        Log.i("TAG", "updateDisplay: 更新日期时间");
        textView.setText(new StringBuffer().append(mMonth + 1).append("-")
                .append(mday).append("-").append(mYear).append((mHour)).append(":")
                .append((mMinute)));
    }

    //日期选择对话框
    private DatePickerDialog.OnDateSetListener mDataSetListener =
            new DatePickerDialog.OnDateSetListener() {
            //  弹出日期对话框
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mday = dayOfMonth;
                    updateDisplay();
                }
            };
    //时间选择对话框
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    mHour = hour;
                    mMinute = minute;
                    updateDisplay();
                }
            };

    //按钮点击弹出
    private void setDialogOnClickListener(int buttonId, final int diallog) {
        Button b = findViewById(buttonId);
        Log.i("TAG", "setDialogOnClickListener: 按钮点击弹出对话框");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(diallog);
            }
        });
    }

//    private static String pad(int c) {
//        Log.i("TAG", "pad: " + c);
//        if (c >= 10)
//            return String.valueOf(c);
//        else
//            return "0" + String.valueOf(c);
//    }
}