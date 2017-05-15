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
 * Created by KBVora on 07-02-2015.
 */
public class festival_custom_adapter extends BaseAdapter {
    Context mContext;
    ArrayList<festival> mArrayList;
    LayoutInflater mLayoutInflater;

    public festival_custom_adapter(Context mContext, ArrayList<festival> mArrayList) {
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

        festival_view_holder mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.gridcustomitem_festival,null);
            mitem=new festival_view_holder((TextView)convertView.findViewById(R.id.gridcustomitem_festival_textView));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (festival_view_holder) convertView.getTag();
        }

        mitem.tv1.setText(mArrayList.get(position).getFestivalname());
        mitem.tv1.setSelected(true);
        return convertView;
    }

}
