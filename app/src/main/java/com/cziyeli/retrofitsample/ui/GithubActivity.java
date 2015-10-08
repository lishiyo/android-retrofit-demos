package com.cziyeli.retrofitsample.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.adapters.GitReposAdapter;
import com.cziyeli.retrofitsample.models.GitRepo;
import com.cziyeli.retrofitsample.models.GitRepoResponse;

/**
 * OkHTTP + GSON with Github API
 * See: https://github.com/codepath/android_guides/wiki/Using-OkHttp
 */
public class GithubActivity extends ActionBarActivity {
	EditText mInput;
	RecyclerView mRecView;
	Button mSearchUsers;
	GitReposAdapter mAdapter;
	GitRepo[] mGitRepos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_github);

		// set views
		mInput = (EditText) findViewById(R.id.github_users_search);
		mRecView = (RecyclerView) findViewById(R.id.github_repos);
		mSearchUsers = (Button) findViewById(R.id.github_users_search_btn);
		mSearchUsers.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				Log.d("connie", "clicked button!");
			}
		});

		// set recyclerview with adapter
		LinearLayoutManager llm = new LinearLayoutManager(this);
		mRecView.setLayoutManager(llm);
		mAdapter = new GitReposAdapter(mGitRepos);
		mRecView.setAdapter(mAdapter);

		setDummyRepos();
	}

	protected void setDummyRepos() {
		final GitRepo[] dummyRepos = GitRepoResponse.getDummyRepos();
		mGitRepos = dummyRepos;
		Log.d("connie", "setDummyRepos: " + dummyRepos.toString());
		mAdapter.updateRepos(dummyRepos);
	}

}
