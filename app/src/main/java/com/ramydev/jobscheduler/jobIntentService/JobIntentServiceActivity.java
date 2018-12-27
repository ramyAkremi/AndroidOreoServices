package com.ramydev.jobscheduler.jobIntentService;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.ramydev.jobscheduler.R;

public class JobIntentServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_intent_service);

    }

    public void enqueueWork(View view) {
        MyJobIntentService.enqueueWork(this, new Intent(this, MyJobIntentService.class));
    }
}
