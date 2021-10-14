package com.imran.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.util.Random;

public class MyIntentService extends IntentService {

    private boolean mRondomNumber;
    private int mRandomNumber;

    private final int MIN=0;
    private final int MAX=100;

    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            mRondomNumber =true;
            startRandomNumberGenerator();
        }
    }

    private void startRandomNumberGenerator() {
        while (mRondomNumber){
            try{
                Thread.sleep(1000);
                if(mRondomNumber){
                    mRandomNumber =new Random().nextInt(MAX)+MIN;
                    Log.i("RandomNumber","Thread id: "+Thread.currentThread().getId()+", Random Number: "+ mRandomNumber);
                }
            }catch (InterruptedException e){
                Log.i("Exception","Thread Interrupted");
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRondomNumber = false;
        Log.i("Destroy", "Thread Id: " + Thread.currentThread().getId());
    }
}