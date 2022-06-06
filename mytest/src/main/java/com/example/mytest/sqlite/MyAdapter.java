package com.example.mytest.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytest.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private final String[] DATA = new String[]{"访客","小雅","小张","小李"};
    private Bitmap mIcon1;
    private int mSelectPosition = -1;
    private LayoutInflater mInflater;

    public MyAdapter(Context context) {
        // Cache the LayoutInflate to avoid asking for a new one each time.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * The number of items in the list is determined by the number of speeches
     * in our array.
     *
     * @see android.widget.ListAdapter#getCount()
     */
    public int getCount() {
        return DATA.length;
    }

    /**
     * Since the data comes from an array, just returning the index is
     * sufficent to get at the data. If we were using a more complex data
     * structure, we would return whatever object represents one row in the
     * list.
     *
     * @see android.widget.ListAdapter#getItem(int)
     */
    public Object getItem(int position) {
        return position;
    }

    /**
     * Use the array index as a unique id.
     *
     * @see android.widget.ListAdapter#getItemId(int)
     */
    public long getItemId(int position) {
        return position;
    }

    public void setSelectPosition(int position) {
        mSelectPosition = position;
        notifyDataSetChanged();
    }


    /**
     * Make a view to hold each row.
     *
     * @see android.widget.ListAdapter#getView(int, View,
     * ViewGroup)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        MyAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_text, null);

            holder = new MyAdapter.ViewHolder();
            holder.linearlayout = (LinearLayout) convertView.findViewById(R.id.content_area);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);

            convertView.setTag(holder);
        } else {
            holder = (MyAdapter.ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.
        holder.text.setText(DATA[position]);
        //holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : null);
        if (mSelectPosition == position) {
            convertView.setSelected(true);
            holder.icon.setVisibility(View.VISIBLE);
        } else {
            convertView.setSelected(false);
            holder.icon.setVisibility(View.GONE);
        }
        return convertView;
    }

    static class ViewHolder {
        LinearLayout linearlayout;
        TextView text;
        ImageView icon;
    }
}
