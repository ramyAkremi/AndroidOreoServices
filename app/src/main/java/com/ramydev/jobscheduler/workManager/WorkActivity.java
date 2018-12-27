package com.ramydev.jobscheduler.workManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ramydev.jobscheduler.R;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

public class WorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        initWorkManager();
    }

    private void initWorkManager() {
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        //OneTimeWorkRequest at specific time
        /*Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long atMidNight = (c.getTimeInMillis() - System.currentTimeMillis());
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(MyWorkManager.class)
                .setInitialDelay(atMidNight, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
                .build();*/
        //PeriodicWorkRequest
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(MyWorkManager.class, 15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();

        WorkManager.getInstance().enqueue(periodicWorkRequest);
    }
}
