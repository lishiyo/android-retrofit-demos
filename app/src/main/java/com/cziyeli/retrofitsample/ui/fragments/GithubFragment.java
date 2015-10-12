package com.cziyeli.retrofitsample.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cziyeli.retrofitsample.R;

/**
 * Created by connieli on 10/11/15.
 */
public class GitHubFragment extends BaseFragment {
	protected String mPageTitle = "GITHUB";

	/**
	 * Factory method to create a new GitHubFragment with data (page position).
	 *
	 * @param args
	 * @return
	 */
	public static GitHubFragment newInstance(final Bundle args) {
		final GitHubFragment fragment = new GitHubFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_github, container, false);

		// test args
		mTitleView = (TextView) view.findViewById(R.id.github_title);
		mTitleView.setText("page: " + mPage);

		return view;
	}

	@Override
	public String getPageTitle() {
		return mPageTitle;
	}
}
