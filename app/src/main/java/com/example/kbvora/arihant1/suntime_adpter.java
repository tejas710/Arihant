package com.example.kbvora.arihant1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jinansh12 on 04-04-15.
 */
public class suntime_adpter extends BaseAdapter {
    Context mContext;
    ArrayList<suntime> mArrayList;
    LayoutInflater mLayoutInflater;

    public suntime_adpter(Context mContext, ArrayList<suntime> mArrayList) {
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

        suntime_view_holder mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.gridcustomitem_tirthankar,null);
            mitem=new suntime_view_holder((ImageView)convertView.findViewById(R.id.imageView2suntime));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (suntime_view_holder) convertView.getTag();
        }


        String str=mArrayList.get(position).getTpath().replace("~/","http://www.jinalshah.brainoorja.com/");
        Picasso.with(mContext).load(str).into(mitem.img);
        return convertView;
    }
}
