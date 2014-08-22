package com.benben.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
public class TitleFragmentAdapter extends FragmentPagerAdapter {
	private String[] CONTENT;
	private  Fragment[] FRAGMENTS;
	public TitleFragmentAdapter(FragmentManager fm,Context context,Fragment[] fragments,String[] titles) {
		super(fm);
		FRAGMENTS = fragments;
		CONTENT = titles;
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

	@Override
	public CharSequence getPageTitle(int position) {
		return CONTENT[position % CONTENT.length];
	}

}

