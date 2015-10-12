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

public class TumblrFragment extends BaseFragment {
	protected String mPageTitle = "TUMBLR";

	public static TumblrFragment newInstance(final Bundle args) {
		final TumblrFragment fragment = new TumblrFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_tumblr, container, false);

		// test args
		mTitleView = (TextView) view.findViewById(R.id.tumblr_title);
		mTitleView.setText("page: " + mPage);

		return view;
	}

	@Override
	public String getPageTitle() {
		return mPageTitle;
	}
}
