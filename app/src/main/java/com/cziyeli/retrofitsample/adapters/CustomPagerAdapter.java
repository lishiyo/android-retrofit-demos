package com.cziyeli.retrofitsample.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.cziyeli.retrofitsample.ui.fragments.BaseFragment;
import com.cziyeli.retrofitsample.ui.fragments.GitHubFragment;
import com.cziyeli.retrofitsample.ui.fragments.TumblrFragment;

/**
 * Created by connieli on 10/11/15.
 */
public class CustomPagerAdapter extends FragmentStatePagerAdapter {
	final int PAGE_COUNT = 2;
	protected Context mContext;
	public static final String KEY_PAGE_POSITION = "page_position";

	public CustomPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		mContext = context;
	}

	/**
	 * Called when the Adapter needs a frag and it does not exist.
	 *
	 * @param position
	 * @return the frag associated with the specific position.
	 */
	@Override
	public BaseFragment getItem(final int position) {
		BaseFragment fragment;

		// Attach some data to populate our fragment layouts
		final Bundle args = new Bundle();
		args.putInt(KEY_PAGE_POSITION, position + 1);

		// Create fragment object
		switch (position) {
		case 0:
			fragment = GitHubFragment.newInstance(args);
			break;
		case 1:
			fragment = TumblrFragment.newInstance(args);
			break;
		default:
			fragment = TumblrFragment.newInstance(args);
		}

		return fragment;
	}

	/**
	 * Specifies how many views to show in the ViewPager. getItem() generates
	 * the views at the specified positions.
	 *
	 * @return
	 */
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// delegate to fragment
		return getItem(position).getPageTitle();
	}
}
