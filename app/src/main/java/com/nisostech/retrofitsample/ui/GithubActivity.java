package com.nisostech.retrofitsample.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.nisostech.retrofitsample.R;

/**
 * OkHTTP + GSON with Github API
 * See: https://github.com/codepath/android_guides/wiki/Using-OkHttp
 */
public class GithubActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_github);
	}

}
