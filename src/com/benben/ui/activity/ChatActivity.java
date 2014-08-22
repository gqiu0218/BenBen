package com.benben.ui.activity;

import com.benben.R;

/**
 *@projectName: BB 
 *@fileName: ChatActivity.java
 *@author:Pengkun 
 *@createDate:2014-8-17 обнГ4:21:06
 *@Description:
 */
public class ChatActivity extends BaseActivity {

	@Override
	public void initViews() {
		setContentView(R.layout.activity_chat);
	}

	@Override
	public void setData() {
		setTitle("адлЛ");
		showBack(false);
		setBtnRight(-1);
	}

	@Override
	public void setListener() {
	}

	@Override
	public void click(int viewId) {
		switch (viewId) {
		case R.id.btnRight:
			//TODO
			break;
		default:
			break;
		}
	}

}
