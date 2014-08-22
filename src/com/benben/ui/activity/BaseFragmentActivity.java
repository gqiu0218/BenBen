package com.benben.ui.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.benben.R;
import com.benben.app.MyApp;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public abstract class BaseFragmentActivity extends FragmentActivity implements OnClickListener{
	protected   String TAG = BaseFragmentActivity.this.getClass().getSimpleName();
	
	public ImageLoader mLoader;
	public DisplayImageOptions options;
	private TextView tvBack,tvTitle,tvRight;
	private Button btnRight;
	@Override
	public void onClick(View v) {
		int viewId = v.getId();
		if(viewId==R.id.tvBack){
			finish();
		}else{
			click(v.getId());
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		MyApp.getInstance().addInstance(this);
		initViews();
		tvBack = (TextView) findViewById(R.id.tvBack);
		tvTitle= (TextView) findViewById(R.id.tvTitle);
		tvRight= (TextView) findViewById(R.id.tvRight);
		btnRight = (Button) findViewById(R.id.btnRight);
		tvBack.setOnClickListener(this);
		tvRight.setOnClickListener(this);
		btnRight.setOnClickListener(this);
		setData();
		setListener();
	}
	
	/***
	 * 设置标题栏右侧按钮
	 * @param resId btnRight
	 */
	public void setBtnRight(int resId){
		btnRight.setVisibility(View.VISIBLE);
		if(resId!=-1)
			btnRight.setBackgroundResource(resId);
	}
	public void showBack(boolean show){
		if(!show)
			tvBack.setVisibility(View.GONE);
	}

	public void setTextRight(String str){
		tvRight.setVisibility(View.VISIBLE);
		tvRight.setText(str);
	}
	public void setTextRight(int textId){
		tvRight.setVisibility(View.VISIBLE);
		tvRight.setText(textId);
	}
	public void setTitle(String title){
		tvTitle.setText(title);
	}
	public void setTitle(int textId){
		tvTitle.setText(textId);
	}
	public abstract void initViews();
	public abstract void setData();
	public abstract void setListener();
	public abstract void click(int viewId);
	
	public void jump(Class<?> clazz,boolean needFinish){
		Intent intent = new Intent(this,clazz);
		startActivity(intent);
		if(needFinish){
			finish();
		}
	}
	public void jump(Intent intent,boolean needFinish){
		startActivity(intent);
		if(needFinish){
			finish();
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			finish();
		}
		return true;
	}
	
	public  void initOptions(int resId){
		options = new DisplayImageOptions.Builder() 
		.showStubImage(resId) 
		.showImageForEmptyUri(resId) 
		.showImageOnFail(resId)
		.cacheInMemory() 
		.cacheOnDisc() 
		.build();
		mLoader =  ImageLoader.getInstance();
	}
	
//	public void loginSucceed(User teacher){
//		DataWrapper.getInstance().setTeahcer(teacher);
//		DataWrapper.getInstance().setLoginSucceed(true);
//		PrefUtils.putString("userName", teacher.getPhone());
//		PrefUtils.putString("password", teacher.getPassword());
//		PrefUtils.putString(Constants.PREF_KEY_TEACHER,teacher.getTeacherInfo());
//	}
//	
//	public void logOut(Class targetClazz,boolean clearPwd,boolean showDialog,boolean needFinish){
//		DataWrapper.getInstance().setTeahcer(null);
//		DataWrapper.getInstance().setLoginSucceed(false);
//		PrefUtils.remove("password");
//		PrefUtils.remove(Constants.PREF_KEY_TEACHER); 
//		showToast( "请重新登录");
//		Intent intent = new Intent(this,targetClazz);
//		intent.putExtra("clearPwd", clearPwd);
//		intent.putExtra("showDialog", showDialog);
//		jump(intent, needFinish);
//	}
	
	public void showConfirmDialog(String title,String msg,String btnText,final boolean needFinish){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title).setMessage(msg).setPositiveButton(btnText, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				if(needFinish){
					Intent intent = getIntent();
					intent.putExtra("reload", true);
					setResult(1, intent);
					BaseFragmentActivity.this.finish();
				}
			}
		}).show();
	}
	public void showChooseDialog(String title,String msg,String btnText,DialogInterface.OnClickListener listener){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title).setMessage(msg).setPositiveButton(btnText, listener)
		.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		}).show();
	}
	
	
}
