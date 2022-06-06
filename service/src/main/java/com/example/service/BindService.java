package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


public class BindService extends Service {
    public SimpleBinder simpleBinder;
    public class SimpleBinder extends Binder{
        /**
         * 获取Service实例
         */
        public BindService getService(){
            Log.e("bind", "getService: ");
            return BindService.this;
        }

    }


    @Override
    public void onCreate() {
        super.onCreate();
        simpleBinder = new SimpleBinder();
        Log.e("bind", "onCreate: ");
    }


    @Override
    public IBinder onBind(Intent intent) {
        return simpleBinder;
    }
}
