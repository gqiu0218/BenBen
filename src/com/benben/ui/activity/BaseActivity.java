package com.benben.ui.activity;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
/**
 *@projectName: BB 
 *@fileName: BaseActivity.java
 *@author:Pengkun 
 *@createDate:2014-8-17 下午4:21:06
 *@Description:所有普通activity的父类
 */
public abstract class BaseActivity extends Activity implements OnClickListener{
	protected   String TAG = BaseActivity.this.getClass().getSimpleName();
	
	public ImageLoader mLoader;
	public DisplayImageOptions options;
	private TextView tvBack,tvTitle,tvRight;
	private Button btnRight;
	/** 记录处于前台的Activity */
	private static BaseActivity mForegroundActivity = null;
	/** 记录所有活动的Activity */
	private static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();
	
	
	
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
	/***
	 * 标题栏是否显示返回
	 * @param show
	 */
	public void showBack(boolean show){
		if(!show)
			tvBack.setVisibility(View.GONE);
	}
	/***
	 * 设置标题栏右侧文字按钮的相关逻辑
	 * @param str
	 */
	public void setTextRight(String str){
		tvRight.setVisibility(View.VISIBLE);
		tvRight.setText(str);
	}
	/***
	 * 设置标题栏右侧文字按钮的相关逻辑
	 * @param textId
	 */
	public void setTextRight(int textId){
		tvRight.setVisibility(View.VISIBLE);
		tvRight.setText(textId);
	}
	/***
	 * 设置标题
	 * @param title
	 */
	public void setTitle(String title){
		tvTitle.setText(title);
	}
	/***
	 * 设置标题
	 * @param textId
	 */
	public void setTitle(int textId){
		tvTitle.setText(textId);
	}
	/***
	 * 初始化布局和控件
	 */
	public abstract void initViews();
	/***
	 * 设置相关数据
	 */
	public abstract void setData();
	/***
	 * 设置各种点击、触摸...监听
	 */
	public abstract void setListener();
	/***
	 * 处理点击事件
	 * @param viewId
	 */
	public abstract void click(int viewId);
	/***
	 * 不带Extra跳转activity
	 * @param clazz
	 * @param needFinish 是否finish当前activity
	 */
	public void jump(Class<?> clazz,boolean needFinish){
		Intent intent = new Intent(this,clazz);
		startActivity(intent);
		if(needFinish){
			finish();
		}
	}
	/***
	 * 带Extra跳转activity
	 * @param clazz
	 * @param needFinish 是否finish当前activity
	 */
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
	/***
	 * 不同的activity里可能需要初始化不同的默认图片，初始化ImgeLoader和默认显示图片
	 * @param resId
	 */
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
	/** 是否有启动的Activity */
	public static boolean hasActivity() {
		return mActivities.size() > 0;
	}

	/** 获取当前处于前台的activity */
	public static BaseActivity getForegroundActivity() {
		return mForegroundActivity;
	}

	/** 获取当前处于栈顶的activity，无论其是否处于前台 */
	public static BaseActivity getCurrentActivity() {
		List<BaseActivity> copy;
		synchronized (mActivities) {
			copy = new ArrayList<BaseActivity>(mActivities);
		}
		if (copy.size() > 0) {
			return copy.get(copy.size() - 1);
		}
		return null;
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
	/***
	 * 只有一个确认按钮的提示dialog
	 * @param title 提示标题
	 * @param msg 提示内容
	 * @param btnText 按钮显示的文字
	 * @param needFinish 关闭dialog的时候是否关闭当前activity
	 */
	public void showConfirmDialog(String title,String msg,String btnText,final boolean needFinish){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title).setMessage(msg).setPositiveButton(btnText, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				if(needFinish){
					BaseActivity.this.finish();
				}
			}
		}).show();
	}
	/***
	 * 有两个按钮的提示dialog
	 * @param title 提示标题
	 * @param msg 提示内容
	 * @param btnText postiveButton上显示的文字
	 * @param listener postiveButton点击监听
	 */
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
