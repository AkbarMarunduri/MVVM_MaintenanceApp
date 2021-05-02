package com.akbarprojec.mvvm_maintenanceapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.akbarprojec.mvvm_maintenanceapp.R;

import java.sql.Time;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(
                () -> startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class)),
                3000
        );

    }
}