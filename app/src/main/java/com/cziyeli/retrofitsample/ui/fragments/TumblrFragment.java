package com.cziyeli.retrofitsample.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.adapters.CustomPagerAdapter;

/**
 * Created by connieli on 10/11/15.
 */
public class TumblrFragment extends Fragment {
	private TextView mFragTitle;

	public TumblrFragment() { // required empty public constructor

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_tumblr, container, false);
		mFragTitle = (TextView) rootView.findViewById(R.id.title);

		// test args
		final Bundle args = getArguments();
		mFragTitle.setText("Page " + args.getInt(CustomPagerAdapter.KEY_PAGE_POSITION));

		return rootView;
	}
}
