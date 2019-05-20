package com.bawei.caolina20190520.homemvp;

import com.bawei.caolina20190520.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public interface IHomeContract {
    public interface IHomeView {
        void getHomePre(String data);
    }

    public interface IHomeModel {
        void request(String surl, CallBackPost post);
    }

    public interface IHomePresent {
        void attach(IHomeView iHomeView);

        void dettach();

        void showList(String surl);
    }
}
