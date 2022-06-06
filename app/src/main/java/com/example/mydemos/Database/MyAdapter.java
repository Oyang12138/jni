package com.example.mydemos.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mydemos.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private MyDataBase myDataBase;
    private Bitmap mIcon1;
    private LayoutInflater mInflater;
    private int mSelectPosition = -1;
    private final String[] data = new String[]{"1111111111","222222222","333333333333"};

//    public String[] getData() {
//        return data;
//    }
//
//    public void setData(String[] data) {
//        this.data = data;
//    }

    //    public String[] getData(MyDataBase m ){
//        myDataBase = new MyDataBase(DataBase.class,"accountname", null, 1);
//        SQLiteDatabase dbRead = m.getReadableDatabase();
//
//       return query(dbRead);
//    }

    public int getCount() {
        return data.length;
    }
    //查询账户数据库内容
    @SuppressLint("Range")
    public String[] query(SQLiteDatabase dbRead) {
        ArrayList<String> arrayList =new ArrayList<>();
        Cursor cursor = dbRead.query("accountname", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
           arrayList.add(cursor.getString(cursor.getColumnIndex("name")));
        }

        return (String[]) arrayList.toArray();
    }
    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


   public Object getItem(int position) {
        return position;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }

    public long getItemId(int position) {
        return position;
    }

    public void setSelectPosition(int position) {
        mSelectPosition = position;
        if(mSelectPosition == -1){
            setSelectPosition(0);
        }
        Log.i("TAG", "setSelectPosition: "+mSelectPosition);
        notifyDataSetChanged();
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        MyAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_text, null);

            holder = new MyAdapter.ViewHolder();
            holder.linearlayout = convertView.findViewById(R.id.content_area);
            holder.text =convertView.findViewById(R.id.text);
            holder.icon =convertView.findViewById(R.id.icon);

            convertView.setTag(holder);
        } else {
            holder = (MyAdapter.ViewHolder) convertView.getTag();

        }
        // Bind the data efficiently with the holder.
        holder.text.setText(data[position]);

        if(mSelectPosition != position){
            holder.text.setText("消失");
            holder.icon.setVisibility(View.GONE);
        }else{
            holder.icon.setVisibility(View.VISIBLE);
        }


        return convertView;
    }


    static class ViewHolder {
        LinearLayout linearlayout;
        TextView text;
        ImageView icon;

        public TextView getText() {
            return text;
        }

        public void setText(TextView text) {
            this.text = text;
        }

        public ImageView getIcon() {
            return icon;
        }

        public void setIcon(ImageView icon) {
            this.icon = icon;
        }
    }


}

