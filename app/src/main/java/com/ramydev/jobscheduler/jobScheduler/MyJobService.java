package com.ramydev.jobscheduler.jobScheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class MyJobService extends JobService {
    private static final String TAG = "MyJobService";
    private boolean isJobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Job Started");
        doBackgroundWork(params);
        return true;
    }

    private void doBackgroundWork(final JobParameters params) {
        Log.d(TAG, "Job Finished");
        jobFinished(params, true);
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "Job cancelled before completion ");
        isJobCancelled = true;
        return true;
    }
}
