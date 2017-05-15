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
 * Created by jinansh12 on 18-01-15.
 */
public class tirth_custom_adapter extends BaseAdapter{

    Context mContext;
    ArrayList<tirth> mArrayList;
    LayoutInflater mLayoutInflater;

    public tirth_custom_adapter(Context mContext, ArrayList<tirth> mArrayList) {
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

        tirth_view_holder   mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.gridcustomitem_tirth,null);
            mitem=new tirth_view_holder((TextView)convertView.findViewById(R.id.gridcustomitem_tirth_textView),(ImageView)convertView.findViewById(R.id.gridcustomitem_tirth_imageview));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (tirth_view_holder) convertView.getTag();
        }

        mitem.tv1.setText(mArrayList.get(position).getName());
        String str=mArrayList.get(position).getPhoto1().replace("~/","http://www.jinalshah.brainoorja.com/");
        Picasso.with(mContext).load(str).into(mitem.img1);
        return convertView;
    }
}
