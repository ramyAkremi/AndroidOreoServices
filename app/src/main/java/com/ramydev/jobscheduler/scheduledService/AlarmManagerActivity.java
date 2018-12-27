package com.ramydev.jobscheduler.scheduledService;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ramydev.jobscheduler.R;

public class AlarmManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduled_service);
        AlarmReceiver.scheduleAlarms(this);

        Toast.makeText(this, "Alarm Seet", Toast.LENGTH_LONG)
                .show();

    }
}