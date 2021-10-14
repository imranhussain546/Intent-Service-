package com.imran.intentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent = new Intent(getApplicationContext(),MyIntentService.class);

    }

    public void startservice(View view) {
        startService(serviceIntent);
    }

    public void stopservice(View view) {
        stopService(serviceIntent);
    }



}