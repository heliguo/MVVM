package com.example.mvvm.Lifecycles;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvm.R;

public class LifecyclesActivity extends AppCompatActivity {

    Chronometer mChronometer;
    MyChronometer mMyChronometer;
    private long elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
        mChronometer = findViewById(R.id.timercount);
        //SystemClock.elapsedRealtime() 系统启动时间
        // System.currentTimeMillis() UNIX 时间
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mMyChronometer = findViewById(R.id.my_timercount);
        getLifecycle().addObserver(mMyChronometer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mChronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        mChronometer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        elapsedTime = SystemClock.elapsedRealtime() - mChronometer.getBase();
        mChronometer.stop();
    }
}