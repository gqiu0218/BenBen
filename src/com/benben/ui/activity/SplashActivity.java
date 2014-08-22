package com.benben.ui.activity;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.benben.R;
import com.benben.utils.LogUtil;

public class SplashActivity extends BaseActivity {
	private LinearLayout rlBottom;
	private RelativeLayout rlRegist;
	private TextView tvLogin;

	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0){
				rlBottom.setVisibility(View.VISIBLE);
			}
		};
	};
	
	@Override
	public void initViews() {
		setContentView(R.layout.activity_splash);
		
		rlBottom = (LinearLayout) findViewById(R.id.llBottom);
		rlRegist = (RelativeLayout) findViewById(R.id.rlRegist);
		tvLogin = (TextView) findViewById(R.id.tvLogin);
		LogUtil.e(TAG, "oncreate........");
		showAnim();
	}
	
	private void showAnim(){
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				SystemClock.sleep(2000);
				return null;
			}
			@Override
			protected void onPostExecute(Void result) {
				handler.sendEmptyMessage(0);
				AlphaAnimation animation = new AlphaAnimation(0f, 1f);
				animation.setDuration(1000);
				animation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						
					}
				});
				rlBottom.startAnimation(animation);
			}
		}.execute();
	}
	
	@Override
	public void setListener() {
		rlRegist.setOnClickListener(this);
		tvLogin.setOnClickListener(this);
	}

	@Override
	public void click(int viewId) {
		switch (viewId) {
		case R.id.rlRegist:
			jump(RegistStep1Activity.class, false);
			break;
		case R.id.tvLogin:
			jump(LoginActivity.class, false);
			break;

		default:
			break;
		}
	}

	@Override
	public void setData() {
	}

}
