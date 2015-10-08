package com.cziyeli.retrofitsample.network;

import com.cziyeli.retrofitsample.network.Responses.LoginResponse;
import com.cziyeli.retrofitsample.models.UserVo;

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
