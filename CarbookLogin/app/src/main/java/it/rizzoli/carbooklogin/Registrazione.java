package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import model.Persona;
import database.PersonaDbAdapter;

public class Registrazione extends AppCompatActivity {

    PersonaDbAdapter pdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        pdb = new PersonaDbAdapter(this);
        pdb.open();

        EditText nameEt = findViewById(R.id.nameEditText);
        EditText surnameEt = findViewById(R.id.surnameEditText);
        EditText emailEt = findViewById(R.id.emailEditText);
        EditText usernameEt = findViewById(R.id.usernameEditText);
        EditText passwordEt = findViewById(R.id.passwordEditText);
        EditText etaEt = findViewById(R.id.ageEditText);
        EditText cittaEt = findViewById(R.id.cityEditText);
        Button buttonSign = findViewById(R.id.signupButton);

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nameEt.getText().toString();
                String cognome = surnameEt.getText().toString();
                String email = emailEt.getText().toString();
                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();
                int eta = 25;//Integer.getInteger(etaEditText.getText().toString());
                String citta = cittaEt.getText().toString();

                Persona persona = new Persona();
                persona.setEmail(email);
                persona.setNome(nome);
                persona.setCognome(cognome);
                persona.setUsername(username);
                persona.setPassword(password);
                persona.setEta(eta);
                persona.setCitta(citta);

                pdb.insertPersona(persona);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (pdb != null)
            pdb.close();
    }

}