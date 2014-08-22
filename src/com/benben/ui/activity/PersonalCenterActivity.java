package com.benben.ui.activity;

import android.widget.RelativeLayout;

import com.benben.R;

/**
 *@projectName: HiShop 
 *@fileName: PersonalCenterActivity.java
 *@author:Pengkun 
 *@createDate:2014-8-16 下午7:50:18
 *@Description:
 */
public class PersonalCenterActivity extends BaseActivity {
	private RelativeLayout rlMyInfo,rlSettings;

	@Override
	public void initViews() {
		setContentView(R.layout.activity_personal_center);
		rlMyInfo = (RelativeLayout) findViewById(R.id.rlMyInfo);
		rlSettings= (RelativeLayout) findViewById(R.id.rlSettings);
	}

	@Override
	public void setListener() {
		rlSettings.setOnClickListener(this);
		rlMyInfo.setOnClickListener(this);
	}

	@Override
	public void click(int viewId) {
		switch (viewId) {
		case R.id.rlMyInfo:
			jump(MyInfoActivity.class, false);
			break;
		case R.id.rlSettings:
			jump(SettingsActivity.class, false);
			break;
		default:
			break;
		}
	}

	@Override
	public void setData() {
		setTitle("个人中心");
		setBtnRight(-1);
		showBack(false);
	}

}
