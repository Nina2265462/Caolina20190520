package com.bawei.caolina20190520.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.caolina20190520.MyApplication;

import java.lang.reflect.Method;

/*
 *@Auther:cln
 *@Date: 2019/5/20
 *@Description:功能
 * */
public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();
    private ConnectivityManager manager;
    private StringRequest request;

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {
    }

    public boolean isNetWord(Context context) {
        manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            return info.isAvailable();
        }
        return false;
    }

    public void doHttpGet(String surl, final CallBackPost post) {
        request = new StringRequest(Request.Method.GET, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post.onFail(error.getMessage());
            }
        });
        MyApplication.getQueue().add(request);
    }
}
