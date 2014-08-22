package com.benben.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
public class FragmentAdapter extends FragmentPagerAdapter {
	private  Fragment[] FRAGMENTS;
	public FragmentAdapter(FragmentManager fm,Context context,Fragment[] fragments) {
		super(fm);
		FRAGMENTS = fragments;
	}

	@Override
	public void setPrimaryItem(ViewGroup container, int position, Object object) {
		super.setPrimaryItem(container, position, object);
	}

	@Override
	public Fragment getItem(int position) {
		return FRAGMENTS[position];
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public int getCount() {
		return FRAGMENTS.length;
	}

}

