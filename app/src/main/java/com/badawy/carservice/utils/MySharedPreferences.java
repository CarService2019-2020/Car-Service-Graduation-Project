package com.badawy.carservice.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class MySharedPreferences {
    private static SharedPreferences mSharedPref;

    public static final String USER_DATA= "UserData";
    public static final String USER_CARS= "UserCars";
    public static final String ABOUT_US= "AboutUs";
    public static final String FIRST_TIME_HELP_GUIDE = "FirstTimeHelpGuide";

    private MySharedPreferences() {

    }

    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }



    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    @SuppressLint("ApplySharedPref")

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    @SuppressLint("ApplySharedPref")

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    @SuppressLint("ApplySharedPref")
    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).commit();
    }

    @SuppressLint("ApplySharedPref")
    public static void remove(String key){
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.remove(key);
        prefsEditor.commit();
    }
}


