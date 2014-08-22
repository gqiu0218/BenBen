package com.benben.ui.activity;

import android.widget.Button;

import com.benben.R;

/**
 *@projectName: BB 
 *@fileName: LoginAactivity.java
 *@author:Pengkun 
 *@createDate:2014-8-17 обнГ4:23:10
 *@Description:
 */
public class LoginActivity extends BaseActivity {

	private Button btnLogin;

	@Override
	public void initViews() {
		setContentView(R.layout.activity_login);
		btnLogin = (Button) findViewById(R.id.btnLogin);
	}
	

	@Override
	public void setListener() {
		btnLogin.setOnClickListener(this);
	}


	@Override
	public void click(int viewId) {
		jump(MainActivity.class, true);
	}


	@Override
	public void setData() {
	}

}
