package com.benben.utils;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.benben.app.MyApp;
/**
 *@projectName: BB 
 *@fileName: PrefUtils.java
 *@author:Pengkun 
 *@createDate:2014-8-17 下午4:21:06
 *@Description:SharedPreferences 操作工具类
 */
public class PrefUtils {

	private static SharedPreferences sp;
	static{
		if (sp == null) {
			sp = PreferenceManager.getDefaultSharedPreferences(MyApp.getInstance());
		}	
	}
	
	public static void remove(String key){
		sp.edit().remove(key).commit();
	}
	public static void putInt(String key,int value){
		sp.edit().putInt(key, value).commit();
	}
	public static void putLong(String key,long value){
		sp.edit().putLong(key, value).commit();
	}
	public static void putString(String key,String value){
		sp.edit().putString(key, value).commit();
	}
	public static void putBoolean(String key,boolean value){
		sp.edit().putBoolean(key, value).commit();
	}
	public static void putFloat(String key,float value){
		sp.edit().putFloat(key, value).commit();
	}
	
	public static int getInt(String key){
		return sp.getInt(key, -1);
	}
	public static long getLong(String key){
		return sp.getLong(key, -1L);
	}
	public static String getString(String key){
		return sp.getString(key, null);
	}
	public static boolean getBoolean(String key,boolean defaultValue){
		return sp.getBoolean(key, defaultValue);
	}
	public static float getFloat(String key){
		return sp.getFloat(key, -1f);
	}
	
}
