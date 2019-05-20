package com.bawei.caolina20190520.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.caolina20190520.R;
import com.bawei.caolina20190520.bean.SeaBean;
import com.bawei.caolina20190520.holder.HomeHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
    private Context context;
    private List<SeaBean.ResultBean> result;
    private View inflate;

    public HomeAdapter(Context context, List<SeaBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder homeHolder, final int i) {
        homeHolder.tv.setText(result.get(i).getCommodityName());
        Glide.with(context)
                .load(result.get(i).getMasterPic())
                .placeholder(R.drawable.ic_favorite_border_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(homeHolder.img);
        homeHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if (itemClick!=null){
            itemClick.Click(result.get(i).getCommodityId());
        }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    //定义回调接口
    private onItemClick itemClick;

    public void setItemClick(onItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface onItemClick {
        void Click(String id);
    }
}
