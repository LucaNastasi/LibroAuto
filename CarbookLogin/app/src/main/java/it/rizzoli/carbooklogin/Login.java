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

        registrazioneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registratiIntent = new Intent(Login.this, Registrazione.class);
                startActivity(registratiIntent);
            }
        });
    }
}