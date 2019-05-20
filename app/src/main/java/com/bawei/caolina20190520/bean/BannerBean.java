package com.bawei.caolina20190520.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public class BannerBean extends SimpleBannerInfo {
    private String bannerUrl;
    private String bannerTitle;

    public BannerBean() {
    }

    public BannerBean(String bannerUrl, String bannerTitle) {
        this.bannerUrl = bannerUrl;
        this.bannerTitle = bannerTitle;
    }

    @Override
    public String getXBannerUrl() {
        return bannerUrl;
    }

    @Override
    public String getXBannerTitle() {
        return bannerTitle;
    }
}
