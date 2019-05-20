package com.bawei.caolina20190520.homemvp;

import com.bawei.caolina20190520.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public class HomePresent implements IHomeContract.IHomePresent {

    private IHomeContract.IHomeView homeView;
    private IHomeContract.IHomeModel model;

    @Override
    public void attach(IHomeContract.IHomeView iHomeView) {
        homeView = iHomeView;
        model = new HomeModel();
    }

    @Override
    public void dettach() {
        if (homeView != null) {
            homeView = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void showList(String surl) {
        model.request(surl, new CallBackPost() {
            @Override
            public void onSuccess(String success) {
                homeView.getHomePre(success);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
