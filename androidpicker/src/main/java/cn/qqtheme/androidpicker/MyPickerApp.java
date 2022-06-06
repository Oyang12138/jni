package cn.qqtheme.androidpicker;

import android.app.Application;

import cn.qqtheme.framework.AppConfig;
import cn.qqtheme.framework.util.LogUtils;



public class MyPickerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.setIsDebug(BuildConfig.DEBUG);
        if (!LogUtils.isDebug()) {
            android.util.Log.d(AppConfig.DEBUG_TAG, "logcat is disabled");
        }
    }

}
