package com.bawei.caolina20190520;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.caolina20190520.bean.BannerBean;
import com.bawei.caolina20190520.bean.ShowInfo;
import com.bawei.caolina20190520.net.CallBackPost;
import com.bawei.caolina20190520.net.HttpUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

public class ShopInfoActivity extends AppCompatActivity implements CallBackPost {

    private XBanner banner;
    private ArrayList<BannerBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);
        banner = findViewById(R.id.banner);
        String id = getIntent().getStringExtra("id");
        HttpUtil.getInstance().doHttpGet(Api.XQURL + id, this);


    }

    @Override
    public void onSuccess(String success) {
        list = new ArrayList<>();
        Gson gson = new Gson();
        ShowInfo info = gson.fromJson(success, ShowInfo.class);
        String[] split = info.result.picture.split(",");
        //解析数据
        for (int i = 0; i < split.length; i++) {
            list.add(new BannerBean(split[i], "我是第" + i + "轮播图"));
        }
        banner.setBannerData(list);
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(ShopInfoActivity.this).load(((BannerBean) model).getXBannerUrl()).into((ImageView) view);
            }
        });


    }

    @Override
    public void onFail(String msg) {

    }
}

