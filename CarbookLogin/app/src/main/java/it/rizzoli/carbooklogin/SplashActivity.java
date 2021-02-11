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
        Log.i("Splash Activity", DatabaseHelper.PERSONA_TABLE_CREATE);
        PersonaDbAdapter personaDb = new PersonaDbAdapter(this);
        personaDb.open();
        Cursor c = personaDb.fetchAllUsers();
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();

            do {
                Log.i("NOME", c.getString(c.getColumnIndex(PersonaDbAdapter.PERSONA_NOME_KEY)));
                Log.i("COGNOME", c.getString(c.getColumnIndex(PersonaDbAdapter.PERSONA_COGNOME_KEY)));
                Log.i("USERNAME", c.getString(c.getColumnIndex(PersonaDbAdapter.PERSONA_USERNAME_KEY)));
                Log.i("PASSWORD", c.getString(c.getColumnIndex(PersonaDbAdapter.PERSONA_PASSWORD_KEY)));
            }
            while (c.moveToNext());
        }

        personaDb.close();


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