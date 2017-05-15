package com.example.kbvora.arihant1;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jinansh12 on 18-03-15.
 */
public class magazine_custom_adpter extends BaseAdapter {
    Context mContext;
    ArrayList<magazines> mArrayList;
    LayoutInflater mLayoutInflater;
    public magazine_custom_adpter(Context mContext, ArrayList<magazines> mArrayList) {
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
        magazine_view_holder mitem;
        if(convertView==null)
        {

            convertView=mLayoutInflater.inflate(R.layout.list_custom_magazine,null);
            mitem=new magazine_view_holder((TextView)convertView.findViewById(R.id.lbl_name_magazine),(TextView)convertView.findViewById(R.id.lbl_editor_magazine),(TextView)convertView.findViewById(R.id.lbl_address_magazine),(TextView)convertView.findViewById(R.id.lbl_telephone1_magazine));
            convertView.setTag(mitem);
        }
        else
        {
            mitem= (magazine_view_holder) convertView.getTag();
        }

        mitem.tv1.setText(mArrayList.get(position).getMname());
        mitem.tv2.setText(mArrayList.get(position).getEditor());
        mitem.tv3.setText(mArrayList.get(position).getAddress());

        String udata=mArrayList.get(position).getTele1();
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        mitem.tv4.setText(content);

        return convertView;

    }




}
