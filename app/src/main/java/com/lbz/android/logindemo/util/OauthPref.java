package com.lbz.android.logindemo.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.lbz.android.logindemo.App;
import com.lbz.android.logindemo.bean.AuthResponse;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public class OauthPref {

    private Context mContext;


    private static OauthPref ourInstance = new OauthPref(App.getContext());

    public static OauthPref getInstance() {
        return ourInstance;
    }

    private OauthPref() {
    }

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;



    public OauthPref(Context context) {
        this.mContext = context;
        sharedPreferences = mContext.getSharedPreferences("login",
                Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setOauthPref(AuthResponse authResponse) {
        editor.putString("token_type", authResponse.token_type);
        editor.putString("access_token", authResponse.access_token);
        editor.commit();
    }

    public String getOauthPref() {
        return sharedPreferences.getString("token_type", null) + " " + sharedPreferences.getString("access_token", null);
    }
}
