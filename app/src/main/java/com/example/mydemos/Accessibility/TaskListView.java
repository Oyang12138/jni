package com.example.mydemos.Accessibility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListView;

public class TaskListView extends ListView {
    public TaskListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
//请求发送辅助功能事件
    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
       AccessibilityEvent record = AccessibilityEvent.obtain();
       super.onInitializeAccessibilityEvent(record);


        return super.onRequestSendAccessibilityEvent(child, event);



    }
}
