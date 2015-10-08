package com.cziyeli.retrofitsample.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.adapters.GitReposAdapter;
import com.cziyeli.retrofitsample.models.GitRepo;
import com.cziyeli.retrofitsample.network.RestError;
import com.cziyeli.retrofitsample.network.github.GitHubAPI;
import com.cziyeli.retrofitsample.network.github.GitHubClient;
import com.cziyeli.retrofitsample.network.github.GitRepoCallback;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * OkHTTP + GSON with Github API
 * See: https://github.com/codepath/android_guides/wiki/Using-OkHttp
 */
public class GithubActivity extends ActionBarActivity {
	EditText mSearchInput;
	RecyclerView mRecView;
	Button mSearchUsers;
	GitReposAdapter mAdapter;
	List<GitRepo> mGitRepos = Collections.emptyList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_github);

		// set views
		mSearchInput = (EditText) findViewById(R.id.github_users_search);
		mRecView = (RecyclerView) findViewById(R.id.github_repos);
		mSearchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView textView, int i, KeyEvent event) {
				if ((i == EditorInfo.IME_ACTION_DONE) ||
						((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && event.getAction() == KeyEvent.ACTION_DOWN)) {

					final String input = mSearchInput.getText().toString();

					if (!input.isEmpty()) {
						fetchGitRepos(input);
						return false;
					}
				}
				return false;
			}
		});

		// set RecyclerView with adapter
		LinearLayoutManager llm = new LinearLayoutManager(this);
		mRecView.setLayoutManager(llm);
		mAdapter = new GitReposAdapter(mGitRepos);
		mRecView.setAdapter(mAdapter);
	}

	/**
	 * Send GET request to users/:user/repos.
	 */
	protected void fetchGitRepos(final String input){
		// Create service from our GitHub API endpoints and GSON converter.
		GitHubAPI gitService = GitHubClient.createService();

		// Call the service asynchronously by passing a callback
		Call<GitRepo[]> call = gitService.getUserRepos(input);
		call.enqueue(getCallback(GitHubClient.GIT_USER_REPOS));
	}

	private Callback getCallback(final int type) {
		switch (type) {
		case GitHubClient.GIT_USER_REPOS:
			return userRepoCallback();
		default:
			return userRepoCallback();
		}
	}

	/**
	 * Retrofit Callbacks - returned on UI thread
	 */

	private Callback userRepoCallback() {
		return new GitRepoCallback<GitRepo[]>() {
			@Override
			public void onResponse(Response<GitRepo[]> response, Retrofit retrofit) {
				final int statusCode = response.code();
				final GitRepo[] repos = response.body();
				final List<GitRepo> gitRepos = Arrays.asList(repos);
				Log.d("connie", "success! " + (gitRepos.size() > 0 ? gitRepos.get(0).toString() : " empty"));
				mGitRepos = gitRepos;
				mAdapter.updateRepos(gitRepos);
			}

			@Override
			public void onFailure(RestError restError) {
				Log.d("connie", "retrofit failed: " + restError.getMessage());
			}
		};
	}

	/*
	DUMMY STUFF
	 */

//	protected void setDummyRepos() {
//		final GitRepo[] dummyRepos = GitRepoResponse.getDummyRepos();
//		mGitRepos = dummyRepos;
//		mAdapter.updateRepos(dummyRepos);
//	}
}
