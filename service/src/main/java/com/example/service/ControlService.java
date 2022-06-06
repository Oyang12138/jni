package com.example.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ControlService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate: "+1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand: " +2);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy: " +3);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "onBind: ");
        return null;
    }
    public class ControlBinder extends Binder{
        public ControlService getService(){
            return ControlService.this;
        }
    }
    //客户端 绑定一个servcie
    private final ServiceConnection mCarServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //传送service
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
