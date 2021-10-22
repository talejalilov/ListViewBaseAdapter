package com.example.lab5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.lab5.R;
import com.example.lab5.model.FastFoodClass;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<FastFoodClass> fastList;
    Context mContext;

    public MyAdapter(ArrayList<FastFoodClass> fastList, Context mContext) {
        this.fastList = fastList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return fastList.size();
    }

    @Override
    public Object getItem(int i) {
        return fastList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewPlaceHolder viewPlaceHolder;

        View convertView = view;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= layoutInflater.inflate(R.layout.list_view_count,viewGroup,false);
            viewPlaceHolder = new ViewPlaceHolder(convertView);
            convertView.setTag(viewPlaceHolder);

        }else {

            viewPlaceHolder = (ViewPlaceHolder) convertView.getTag();

        }

        FastFoodClass listClass = fastList.get(i);

        viewPlaceHolder.fastPic.setImageResource(listClass.imageId);
        viewPlaceHolder.fastName.setText(listClass.fastFoodName);
        viewPlaceHolder.textView.setText(listClass.position);
        return convertView;
    }

}
