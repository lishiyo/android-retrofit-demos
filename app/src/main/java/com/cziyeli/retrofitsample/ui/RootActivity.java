package com.cziyeli.retrofitsample.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.adapters.CustomPagerAdapter;

/**
 * Root activity to hold the tab fragments.
 */

public class RootActivity extends FragmentActivity {
	CustomPagerAdapter mCustomPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_root);

		// Get the ViewPager and connect our adapter.
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(),
				RootActivity.this);
		mViewPager.setAdapter(mCustomPagerAdapter);

		// Set the TabLayout with our ViewPager
		final TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
		tabLayout.setupWithViewPager(mViewPager);
	}

}
