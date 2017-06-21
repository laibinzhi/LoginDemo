package com.lbz.android.logindemo.network.interceptor;

import android.text.TextUtils;

import com.lbz.android.logindemo.util.OauthPref;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by laibinzhi on 2017/6/21.
 */
public class OauthHeaderRequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();

        final String token = OauthPref.getInstance().getOauthPref();

        if (!TextUtils.isEmpty(token)) {
            builder.addHeader("Authorization", token);
        }
        return chain.proceed(builder.build());
    }
}
