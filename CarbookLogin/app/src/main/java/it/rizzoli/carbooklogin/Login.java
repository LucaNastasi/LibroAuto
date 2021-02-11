package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button registrazioneButton = findViewById(R.id.buttonRegistrazione);
        Button accediButton = findViewById(R.id.buttonAccedi);

        accediButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accediIntent = new Intent(Login.this, MainActivity.class);
                startActivity(accediIntent);
            }
        });

        registrazioneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registratiIntent = new Intent(Login.this, Registrazione.class);
                startActivity(registratiIntent);
            }
        });
    }
}