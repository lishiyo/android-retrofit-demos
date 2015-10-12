package com.cziyeli.retrofitsample.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import com.cziyeli.retrofitsample.adapters.CustomPagerAdapter;

/**
 * Interfaces can define static methods and default methods.
 * Abstract classes - can define state. But are NOT instantiated.
 * You must implement any abstract methods.
 */
public abstract class BaseFragment extends Fragment {
	protected int mPage;
	protected TextView mTitleView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mPage = getArguments().getInt(CustomPagerAdapter.KEY_PAGE_POSITION);
	}

	public abstract String getPageTitle();
}