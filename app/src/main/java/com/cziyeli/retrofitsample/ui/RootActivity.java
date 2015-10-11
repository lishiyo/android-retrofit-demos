package com.cziyeli.retrofitsample.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.adapters.CustomPagerAdapter;

/**
 * Root activity to hold the tab fragments.
 */

public class RootActivity extends AppCompatActivity {
	CustomPagerAdapter mCustomPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_root);



	}

}
