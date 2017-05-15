package com.example.kbvora.arihant1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KBVora on 29-03-2015.
 */
public class pachakhan_custom_adpter extends BaseAdapter {
    Context mContext;
    ArrayList<pachakhan> mArrayList;
    LayoutInflater mLayoutInflater;
    public pachakhan_custom_adpter(Context mContext, ArrayList<pachakhan> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        pachakhan_view_holder mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.listcustom_pachakhan,null);
            mitem=new pachakhan_view_holder((TextView)convertView.findViewById(R.id.grid_pachakhan_textView));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (pachakhan_view_holder) convertView.getTag();
        }

        mitem.tv1.setText(mArrayList.get(position).getPname());
        mitem.tv1.setSelected(true);

        return convertView;

    }




}

