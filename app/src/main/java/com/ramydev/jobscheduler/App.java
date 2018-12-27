package com.ramydev.jobscheduler;

import android.app.Application;

import com.evernote.android.job.JobManager;
import com.ramydev.jobscheduler.evernoteAndroidJob.DemoJobCreator;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JobManager.create(this).addJobCreator(new DemoJobCreator());
    }
}
