package com.ramydev.jobscheduler.workManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ramydev.jobscheduler.R;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.NetworkType;
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
        //OneTimeWorkRequest
        /*OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(MyWorkManager.class)
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
