package com.example.jeson.listview_simplepractical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Jeson on 2016/5/14.
 * 动物适配器
 */
public class AnimalAdapter extends BaseAdapter {

    private LinkedList<Animals> mData;
    private Context mContext;

    public AnimalAdapter(LinkedList<Animals> data, Context context) {
        mData = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.animal_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.mIcon = (ImageView) convertView.findViewById(R.id.animal_icon);
            viewHolder.mName = (TextView) convertView.findViewById(R.id.animal_name);
            viewHolder.mSay = (TextView) convertView.findViewById(R.id.animal_say);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mIcon.setBackgroundResource(mData.get(position).getaIcon());
        viewHolder.mName.setText(mData.get(position).getaName());
        viewHolder.mSay.setText(mData.get(position).getaSay());

        return convertView;
    }

    static class ViewHolder {
        ImageView mIcon;
        TextView mName;
        TextView mSay;
    }
}
