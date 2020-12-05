package com.example.calcoin.ACTIVITYS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.calcoin.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // bildirim çubuğunu gizliyor
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { // 4 saniye sonra main aktivity'i açıyor

              Intent intent=new Intent(Splash.this, MainActivity.class);
              startActivity(intent);
            }
        },3500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               finish();
            }
        },6000);

    }
}
