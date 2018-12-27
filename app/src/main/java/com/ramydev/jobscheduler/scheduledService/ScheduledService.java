package com.ramydev.jobscheduler.scheduledService;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class ScheduledService extends JobIntentService {
    private static final int UNIQUE_JOB_ID = 1337;

    static void enqueueWork(Context ctxt) {
        enqueueWork(ctxt, ScheduledService.class, UNIQUE_JOB_ID,
                new Intent(ctxt, ScheduledService.class));
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d("AlarmManager", "I ran!");

    }
}
