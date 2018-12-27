package com.ramydev.jobscheduler.scheduledService;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class AlarmReceiver extends BroadcastReceiver {
    private static final int PERIOD =  60* 5 * 1000;
    private static final int INITIAL_DELAY = 60 * 1000;

    static void scheduleAlarms(Context ctxt) {
        AlarmManager mgr = (AlarmManager) ctxt.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(ctxt, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(ctxt, 0, i, 0);

        mgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + INITIAL_DELAY,
                PERIOD, pi);

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == intent.getAction())
            ScheduledService.enqueueWork(context);
        else
            scheduleAlarms(context);
    }
}
