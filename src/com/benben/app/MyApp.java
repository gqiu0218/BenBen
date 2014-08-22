package com.benben.app;

import java.util.Stack;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.benben.utils.LogUtil;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 *@projectName: BB 
 *@fileName: MyApp.java
 *@author:Pengkun 
 *@createDate:2014-8-17 下午4:34:24
 *@Description:
 */
public class MyApp extends Application {
	private static final String TAG = "MyApp";
	private static MyApp instance;
	private Stack<Activity> activitiesStack;
	/** 主线程ID */
	private static int mMainThreadId = -1;
	/** 主线程ID */
	private static Thread mMainThread;
	/** 主线程Handler */
	private static Handler mMainThreadHandler;
	/** 主线程Looper */
	private static Looper mMainLooper;

	
	@Override
	public void onCreate() {
		super.onCreate();
		LogUtil.e(TAG, "onCreate......");
		instance = this;
		mMainThreadId = android.os.Process.myTid();
		mMainThread = Thread.currentThread();
		mMainThreadHandler = new Handler();
		mMainLooper = getMainLooper();
		/***
		 * 初始化ImageLoader的相关设置
		 */
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this).denyCacheImageMultipleSizesInMemory()
				.memoryCache(new LruMemoryCache(5 * 1024 * 1024))
				.memoryCacheSize(5 * 1024 * 1024)
				.discCacheSize(50 * 1024 * 1024)
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024)
				.discCacheSize(50 * 1024 * 1024).discCacheFileCount(500)
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.discCacheFileCount(100).build();
		ImageLoader.getInstance().init(config);
	}
	public static MyApp getInstance(){
		return instance;
	}
	
	public void exit(){
		deleteAllActivity();
		System.exit(0);
		System.gc();
	}
	/***
	 * 将新建的activity的添加到容器
	 * @param aInstance
	 */
	public void addInstance(Activity aInstance) {
		if (activitiesStack == null)
			activitiesStack = new Stack<Activity>();
		final int index = activitiesStack.lastIndexOf(aInstance);
		if (index >= 0)
			activitiesStack.remove(index);
		activitiesStack.add(aInstance);
	}
	/***
	 * 程序退出时finish掉所有的activity
	 */
	private void deleteAllActivity() {
		if (activitiesStack == null)
			return;
		final int size = activitiesStack.size();
		for (int i = 0; i < size; i++) {
			Activity activity = activitiesStack.get(i);
			if (null != activity) {
				activity.finish();
			}
		}
		activitiesStack.clear();
		activitiesStack = null;
	}
	/** 获取主线程ID */
	public static int getMainThreadId() {
		return mMainThreadId;
	}

	/** 获取主线程 */
	public static Thread getMainThread() {
		return mMainThread;
	}

	/** 获取主线程的handler */
	public static Handler getMainThreadHandler() {
		return mMainThreadHandler;
	}

	/** 获取主线程的looper */
	public static Looper getMainThreadLooper() {
		return mMainLooper;
	}

}
