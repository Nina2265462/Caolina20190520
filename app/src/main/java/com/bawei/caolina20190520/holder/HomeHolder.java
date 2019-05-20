package com.bawei.caolina20190520.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.caolina20190520.R;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public class HomeHolder extends RecyclerView.ViewHolder {

    public ImageView img;
    public TextView tv;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        tv = itemView.findViewById(R.id.tv);
    }
}
