package com.bawei.caolina20190520.homemvp;

import com.bawei.caolina20190520.net.CallBackPost;
import com.bawei.caolina20190520.net.HttpUtil;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public class HomeModel implements IHomeContract.IHomeModel {

    private final HttpUtil util;

    public HomeModel() {
        util = HttpUtil.getInstance();
    }

    @Override
    public void request(String surl, final CallBackPost post) {
        util.doHttpGet(surl, new CallBackPost() {
            @Override
            public void onSuccess(String success) {
                post.onSuccess(success);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
