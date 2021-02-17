package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import database.DatabaseHelper;
import database.PersonaDbAdapter;

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