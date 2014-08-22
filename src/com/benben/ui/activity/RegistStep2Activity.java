package com.benben.ui.activity;

import android.widget.Button;

import com.benben.R;

public class RegistStep2Activity extends BaseActivity {
	private Button btnNext;

	@Override
	public void initViews() {
		setContentView(R.layout.activity_register_2);
		btnNext = (Button) findViewById(R.id.btnNext);
	}

	@Override
	public void setListener() {
		btnNext.setOnClickListener(this);
	}

	@Override
	public void click(int viewId) {
		jump(RegistStep3Activity.class, false);
	}

	@Override
	public void setData() {
		setTitle("确认验证码");
	}

}
