package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import fragments.HomeFragment;
import it.rizzoli.carbooklogin.R;

public class RegistraAutoSplash extends AppCompatActivity {
    private final static int SPLASH_TIMER = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_auto_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                Intent DescrizioneAnnuncioIntent = new Intent(RegistraAutoSplash.this, MainActivity.class);
                startActivity(DescrizioneAnnuncioIntent);
                finish();
            }
        }, SPLASH_TIMER);

    }
}