package it.rizzoli.carbooklogin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import it.rizzoli.carbooklogin.R;

public class SplashActivity extends AppCompatActivity {

    private final static int SPLASH_TIMER = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                Intent loginIntent = new Intent(SplashActivity.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        }, SPLASH_TIMER);
    }
}