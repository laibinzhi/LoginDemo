package com.lbz.android.logindemo.bean;

import java.io.Serializable;


/**
 * Created by laibinzhi on 2017/2/21.
 */

public class AuthResponse implements Serializable {
    public String access_token;
    public String token_type;
    public long expires_in;
    public String scope;
    public String error;
    public String refresh_token;

    public String msg;
    public int code;
    public boolean success;

    @Override
    public String toString() {
        return String.format(
                "access_token=%s; token_type=%s; expires_in=%d; scope=%s; refresh_token=%s",
                access_token, token_type, expires_in, scope, refresh_token);
    }

    public boolean isSuccess() {
        return (error == null && access_token != null);
    }

}
