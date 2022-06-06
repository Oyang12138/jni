package com.example.accountname;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


class AccoutAdapter extends BaseAdapter{
    private final String[] DATA = new String[] {"访客","小雅小雅","小明小明"};
    private Bitmap mIcon1;
    private int mSelectPosition = 0;
    private LayoutInflater mInflater;
    private String accountname;
    public AccoutAdapter(Context context) {
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
    }


    /**
     * Make a view to hold each row.
     *
     * @see android.widget.ListAdapter#getView(int, View,
     *      ViewGroup)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        AccoutAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_text, null);
            holder = new AccoutAdapter.ViewHolder();
            holder.linearlayout = (LinearLayout) convertView.findViewById(R.id.content_area);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);

        } else {
            holder = (AccoutAdapter.ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.
        holder.text.setText(DATA[position]);
        //holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : null);
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "onClick: "+position);
                setSelectPosition(position);
                notifyDataSetChanged();
                setAccountname(holder.text.getText().toString());
                Log.i("TAG", "onClick: "+accountname);
            }
        });
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

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
}
