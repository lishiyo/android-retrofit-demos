package com.nisostech.retrofitsample.network;

import com.nisostech.retrofitsample.network.Responses.LoginResponse;
import com.nisostech.retrofitsample.models.UserVo;

import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Soham Banerjee on 13/3/15.
 */

public interface RestAPI {
    @POST("/user/login")
    void login(@Body UserVo user,
               RestCallback<LoginResponse> callback);
}
