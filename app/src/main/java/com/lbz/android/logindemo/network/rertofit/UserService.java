package com.lbz.android.logindemo.network.rertofit;

import android.support.annotation.NonNull;

import com.lbz.android.logindemo.bean.AuthResponse;
import com.lbz.android.logindemo.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by laibinzhi on 2017/2/21.
 */
public interface UserService {

    @NonNull
    @FormUrlEncoded
    @POST("/oauth2/access_token/")
    Observable<AuthResponse> login(@Field("grant_type") String grant_type,
                                   @Field("client_id") String client_id,
                                   @Field("username") String username,
                                   @Field("password") String password);


    @GET("/api/user/v1/accounts/{username}")
    Observable<User> getUser(@Path("username") String username);
}
