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
 * Created by KBVora on 24-01-2015.
 */
public class Tirthankar_custom_adpter extends BaseAdapter {
    Context mContext;
    ArrayList<Tirthankarcon> mArrayList;
    LayoutInflater mLayoutInflater;

    public Tirthankar_custom_adpter(Context mContext, ArrayList<Tirthankarcon> mArrayList) {
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

        Tirthankarview_holder mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.gridcustomitem_tirthankar,null);
            mitem=new Tirthankarview_holder((TextView)convertView.findViewById(R.id.gridcustomitem_tirthankar_textView),(ImageView)convertView.findViewById(R.id.gridcustomitem_tirthankar_imageview));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (Tirthankarview_holder) convertView.getTag();
        }

        mitem.tv1.setText(mArrayList.get(position).getTirthankar());
        String str=mArrayList.get(position).getPhoto1().replace("~/","http://www.jinalshah.brainoorja.com/");
        Picasso.with(mContext).load(str).into(mitem.img1);
        return convertView;
    }
}
