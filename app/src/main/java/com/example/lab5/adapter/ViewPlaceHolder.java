package com.example.lab5.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5.R;

public class ViewPlaceHolder {

    ImageView fastPic;
    TextView fastName;

    public ViewPlaceHolder(View view) {

        fastPic = view.findViewById(R.id.fastPic);
        fastName = view.findViewById(R.id.fastName);
    }
}
