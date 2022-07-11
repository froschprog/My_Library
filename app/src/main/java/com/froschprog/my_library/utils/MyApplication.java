package com.froschprog.my_library.utils;

import android.app.Application;

// this class is used to get the Context...
public class MyApplication extends Application {

    private static MyApplication instance;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static MyApplication getInstance(){return instance;}
}
