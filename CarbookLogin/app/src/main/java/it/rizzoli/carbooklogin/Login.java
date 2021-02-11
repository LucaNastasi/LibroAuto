package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.PersonaDbAdapter;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button registrazioneButton = findViewById(R.id.buttonRegistrazione);
        Button accediButton = findViewById(R.id.buttonAccedi);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEdittext = findViewById(R.id.passwordEditText);
        accediButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEdittext.getText().toString();
                PersonaDbAdapter personaDb = new PersonaDbAdapter(Login.this);
                personaDb.open();
                Cursor c = personaDb.fetchUserBy(email, password );
                if (c != null) {
                    c.moveToFirst();
                }
                if(c.getCount() > 0){
                    Intent accediIntent = new Intent(Login.this, MainActivity.class);
                    startActivity(accediIntent);
                }
                personaDb.close();
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