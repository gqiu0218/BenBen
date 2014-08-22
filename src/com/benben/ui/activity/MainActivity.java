package com.benben.ui.activity;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.benben.R;
import com.benben.app.MyApp;

public class MainActivity extends TabActivity implements OnCheckedChangeListener {
	private TabHost tabHost; 
	private RadioGroup rb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyApp.getInstance().addInstance(this);
		tabHost = getTabHost();
		rb = (RadioGroup) findViewById(R.id.rg);
		tabHost.addTab(tabHost.newTabSpec("contact").setIndicator("",getResources().getDrawable(R.drawable.main_bottom_tab_home_normal)).setContent(new Intent(this, ContactActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("chat").setIndicator("",getResources().getDrawable(R.drawable.main_bottom_tab_category_normal)).setContent(new Intent(this, ChatActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("private").setIndicator("",getResources().getDrawable(R.drawable.main_bottom_tab_category_normal)).setContent(new Intent(this, PersonalOrderActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("mine").setIndicator("",getResources().getDrawable(R.drawable.main_bottom_tab_story_normal)).setContent(new Intent(this, PersonalCenterActivity.class)));
		tabHost.setCurrentTab(0);
		rb.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb0:
			tabHost.setCurrentTabByTag("contact");
			break;
		case R.id.rb1:
			tabHost.setCurrentTabByTag("chat");
			break;
		case R.id.rb2:
			tabHost.setCurrentTabByTag("private");
			break;
		case R.id.rb3:
			tabHost.setCurrentTabByTag("mine");
			break;
		default:
			break;
		}
	}
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {//&& event.getAction() == KeyEvent.ACTION_DOWN&& event.getRepeatCount() == 0
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提醒");
			builder.setCancelable(true);
			builder.setMessage("确认要退出吗？");
			builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					MyApp.getInstance().exit();
				}
			});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			} );
			builder.create().show();
		}
		return super.dispatchKeyEvent(event);
	}
}
