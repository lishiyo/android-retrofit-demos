package com.cziyeli.retrofitsample.network.github;

import android.util.Log;
import com.cziyeli.retrofitsample.network.RestError;
import retrofit.Callback;

/**
 * GET users/:user/repos callback.
 */

public abstract class GitRepoCallback<T> implements Callback<T> {
	public abstract void onFailure(RestError restError);

	@Override
	public void onFailure(Throwable t) {
		// Log error here since request failed
		Log.d("connie", "retrofit failed: " + t.getMessage());
	}
}