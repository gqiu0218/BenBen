package com.benben.utils;

import android.content.Context;
import android.widget.Toast;
/**
 *@projectName: BB 
 *@fileName: MyToast.java
 *@author:Pengkun 
 *@createDate:2014-8-17 下午4:21:06
 *@Description:吐司提示工具类
 */
public class MyToast {
	public static void show(Context context,String content){
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}
	public static void show(Context context,int resId){
		Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
	}
	public static void show(Context context,int resId,int duration){
		Toast.makeText(context, resId, duration).show();
	}
	public static void show(Context context,String content,int duration){
		Toast.makeText(context, content, duration).show();
	}
}
