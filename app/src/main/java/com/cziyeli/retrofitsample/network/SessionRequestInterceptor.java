package com.cziyeli.retrofitsample.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;

import java.io.IOException;

/**
 * Created by Soham Banerjee on 13/3/15.
 */

public class SessionRequestInterceptor {
    private static final String TAG = SessionRequestInterceptor.class.getSimpleName();
//
//    @Override
//    public void intercept(RequestFacade request) {
//        request.addHeader("Content-Type", "application/json");//you can add header here if you need in your api
//    }

    public com.squareup.okhttp.Response intercept(Interceptor.Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder().addHeader("User-Agent", "Retrofit-Sample-App").build();
        return chain.proceed(newRequest);
    }
}