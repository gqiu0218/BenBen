package com.benben.ui.activity;

import com.benben.R;

/**
 *@projectName: BB 
 *@fileName: EditNameActivity.java
 *@author:Pengkun 
 *@createDate:2014-8-16 ÏÂÎç7:42:38
 *@Description:
 */
public class EditNameActivity extends BaseActivity {

	@Override
	public void initViews() {
		setContentView(R.layout.activity_edit_name);
	}
	@Override
	public void setListener() {
	}

	@Override
	public void click(int viewId) {
		switch (viewId) {
		case R.id.tvRight:
			
			break;
		default:
			break;
		}
	}
	@Override
	public void setData() {
		setTextRight("±£´æ");
	}

}
