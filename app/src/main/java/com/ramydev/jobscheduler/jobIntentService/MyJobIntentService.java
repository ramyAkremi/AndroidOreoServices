package com.ramydev.jobscheduler.jobIntentService;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class MyJobIntentService extends JobIntentService {
    private static final String TAG = "JobIntentService";
    private static final int JOB_ID = 12345;
    Alarm alarm = new Alarm();
    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, MyJobIntentService.class, JOB_ID, work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "JobIntentService Created!");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG, "onHandleWork");
        alarm.setAlarm(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "JobIntentService Destroyed!");
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(TAG, "onStopCurrentWork" + super.onStopCurrentWork());
        return super.onStopCurrentWork();
    }
}
