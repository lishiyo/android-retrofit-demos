package com.cziyeli.retrofitsample.network;

import android.util.Log;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Callbacks in Retrofit are dispatched on the main thread, unless OKHttp which uses worker thread.
 */

public abstract class RestCallback<T> implements Callback<T> {
    public abstract void onFailure(RestError restError);

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        Log.d("connie", "onResponse code: " + response.code() + " with body: " + response.body());
    }

    @Override
    public void onFailure(Throwable t) {
        // Log error here since request failed
    }

//    @Override
//    public void failure(RestError error) {
//        RestError restError = (RestError) error.getBodyAs(RestError.class); // create your own class as
//        // how the error message gonna showup from server side if there is an error
//        if (restError != null)
//            failure(restError);
//        else {
//            failure(new RestError(error.getMessage()));
//        }
//    }
}