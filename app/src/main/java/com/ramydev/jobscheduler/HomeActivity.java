package com.ramydev.jobscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ramydev.jobscheduler.jobIntentService.JobIntentServiceActivity;
import com.ramydev.jobscheduler.jobScheduler.JobSchedulerActivity;
import com.ramydev.jobscheduler.scheduledService.AlarmManagerActivity;
import com.ramydev.jobscheduler.workManager.WorkActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onJobSchedulerClicked(View view) {
        startActivity(new Intent(this, JobSchedulerActivity.class));

    }

    public void onJobIntentServiceClicked(View view) {
        startActivity(new Intent(this, JobIntentServiceActivity.class));

    }

    public void onAlarmServiceClicked(View view) {
        startActivity(new Intent(this, AlarmManagerActivity.class));

    }


    public void onWorkManagerClicked(View view) {
        startActivity(new Intent(this, WorkActivity.class));
    }

}
