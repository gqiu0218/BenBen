package com.benben.ui.activity;

import android.widget.RelativeLayout;

import com.benben.R;

/**
 *@projectName: HiShop 
 *@fileName: MyInfoActivity.java
 *@author:Pengkun 
 *@createDate:2014-8-16 下午7:23:29
 *@Description:
 */
public class MyInfoActivity extends BaseActivity {
	private RelativeLayout rlName;

	@Override
	public void initViews() {
		setContentView(R.layout.activity_my_info);
		rlName = (RelativeLayout) findViewById(R.id.rlName);
	}

	@Override
	public void setListener() {
		rlName.setOnClickListener(this);
	}

	@Override
	public void click(int viewId) {
		switch (viewId) {
		case R.id.rlName:
			jump(EditNameActivity.class, false);
			break;
		default:
			break;
		}
	}

	@Override
	public void setData() {
		setTitle("个人信息");
	}

}
