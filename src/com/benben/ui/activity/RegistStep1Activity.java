package com.benben.ui.activity;

import android.widget.Button;

import com.benben.R;

public class RegistStep1Activity extends BaseActivity{
	private Button btnNext;

	@Override
	public void initViews() {
		setContentView(R.layout.activity_register_1);
		btnNext = (Button) findViewById(R.id.btnNext);
	}

	@Override
	public void setListener() {
		btnNext.setOnClickListener(this);
	}

	@Override
	public void click(int viewId) {
		jump(RegistStep2Activity.class, false);
	}

	@Override
	public void setData() {
		setTitle("使用手机号注册");
	}
}
