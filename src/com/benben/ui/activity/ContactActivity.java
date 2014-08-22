package com.benben.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.benben.R;
import com.benben.adapter.TitleFragmentAdapter;
import com.benben.ui.fragment.TestFragment;
import com.viewpagerindicator.TabPageIndicator;

/**
 *@projectName: BB 
 *@fileName: ContactActivity.java
 *@author:Pengkun 
 *@createDate:2014-8-17 下午4:22:18
 *@Description:
 */
public class ContactActivity extends BaseFragmentActivity implements OnPageChangeListener {
	private TabPageIndicator indicator ;
	private ViewPager viewPager;
	private TitleFragmentAdapter adapter;
	private String[] contents = {"好友","政企","群组","号码直通车"};

	@Override
	public void initViews() {
		setContentView(R.layout.activity_contact);
		indicator = (TabPageIndicator) findViewById(R.id.indicator);
		viewPager = (ViewPager) findViewById(R.id.pager);
		Fragment frags[] = {TestFragment.newInstance(contents[0]),TestFragment.newInstance(contents[1]),TestFragment.newInstance(contents[2]),TestFragment.newInstance(contents[3])};
		adapter = new TitleFragmentAdapter(getSupportFragmentManager(), this, frags, contents);
		viewPager.setAdapter(adapter);
		indicator.setViewPager(viewPager);
		indicator.setOnPageChangeListener(this);
	}

	@Override
	public void setData() {
		showBack(false);
		setTitle("犇犇");
		setBtnRight(-1);
	}

	@Override
	public void setListener() {
	}

	@Override
	public void click(int viewId) {
		switch (viewId) {
		case R.id.btnRight:
			
			break;
		default:
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
	}

}