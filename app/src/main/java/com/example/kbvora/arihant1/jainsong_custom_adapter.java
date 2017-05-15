package com.example.kbvora.arihant1;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.util.ArrayList;

/**
 * Created by KBVora on 01-03-2015.
 */
public class jainsong_custom_adapter extends BaseAdapter{
    Context mContext;
    ArrayList<jainsong> mArrayList;
    LayoutInflater mLayoutInflater;



    public jainsong_custom_adapter(Context mContext, ArrayList<jainsong> mArrayList) {
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

        jainsongs_view_holder mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.gridcustomitem_jainsongs,null);
            mitem=new jainsongs_view_holder((TextView)convertView.findViewById(R.id.gridcustomitem_jain_Songs_textView));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (jainsongs_view_holder) convertView.getTag();
        }

        mitem.tv1.setText(mArrayList.get(position).getJainsongs_name());
        mitem.tv1.setSelected(true);
         return convertView;
    }
}
