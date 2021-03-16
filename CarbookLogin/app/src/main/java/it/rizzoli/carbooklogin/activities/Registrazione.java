package it.rizzoli.carbooklogin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.PersonaApi;
import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.model.Persona;
import it.rizzoli.carbooklogin.database.PersonaDbAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registrazione extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEt, nameEt, surnameEt, usernameEt, passwordEt, telefonoEt, cittaEt;
    PersonaDbAdapter pdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        nameEt = findViewById(R.id.nameEditText);
        surnameEt = findViewById(R.id.surnameEditText);
        emailEt = findViewById(R.id.emailEditText);
        usernameEt = findViewById(R.id.usernameEditText);
        passwordEt = findViewById(R.id.passwordEditText);
        telefonoEt = findViewById(R.id.phoneEditText);
        cittaEt = findViewById(R.id.cityEditText);
        findViewById(R.id.signupButton).setOnClickListener(this);
    }

    private void registrazione() {
        String nome = nameEt.getText().toString().trim();
        String cognome = surnameEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        String username = usernameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        String telefono = telefonoEt.getText().toString().trim();
        String citta = cittaEt.getText().toString().trim();

        if (email.isEmpty()) {
            emailEt.setError("L'email è obbligatoria");
            emailEt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEt.setError("Inserisci email valida");
            emailEt.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            passwordEt.setError("La password è obbligatoria");
            passwordEt.requestFocus();
            return;
        }
        if (password.length() < 6) {
            passwordEt.setError("La password deve essere almeno di 6 caratteri");
            passwordEt.requestFocus();
            return;
        }
        if (nome.isEmpty()) {
            nameEt.setError("Il nome è obbligatorio");
            nameEt.requestFocus();
            return;
        }
        if (cognome.isEmpty()) {
            surnameEt.setError("Il cognome è obbligatorio");
            surnameEt.requestFocus();
            return;
        }
        if (citta.isEmpty()) {
            cittaEt.setError("La città è obbligatoria");
            cittaEt.requestFocus();
            return;
        }
        if (username.isEmpty()) {
            usernameEt.setError("Lo username è obbligatorio");
            usernameEt.requestFocus();
            return;
        }
        if (telefono.isEmpty()) {
            telefonoEt.setError("Il numero di telefono è obbligatorio");
            telefonoEt.requestFocus();
            return;
        }

        Persona p = new Persona();
        p.setCitta(citta);
        p.setCognome(cognome);
        p.setEmail(email);
        p.setNome(nome);
        p.setPassword(password);
        p.setTelefono(telefono);
        p.setUsername(username);

        PersonaApi ri = RetrofitManager.retrofit.create(PersonaApi.class);
        Call<Persona> nuovaPersona = ri.nuovaPersona(p);
        nuovaPersona.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.code() == 200) {
                    String s = response.body().toString();

                    pdb = new PersonaDbAdapter(Registrazione.this);
                    pdb.open();
                    Persona persona = response.body();
                    pdb.insertPersona(persona);

                    Toast.makeText(Registrazione.this, s, Toast.LENGTH_LONG).show();
                    Intent login = new Intent(Registrazione.this, Login.class);
                    startActivity(login);
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(Registrazione.this, "Errore", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (pdb != null)
            pdb.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signupButton:
                registrazione();
                break;
        }
    }
}

/* pdb = new PersonaDbAdapter(this);
        pdb.open();

        EditText nameEt = findViewById(R.id.nameEditText);
        EditText surnameEt = findViewById(R.id.surnameEditText);
        EditText emailEt = findViewById(R.id.emailEditText);
        EditText usernameEt = findViewById(R.id.usernameEditText);
        EditText passwordEt = findViewById(R.id.passwordEditText);
        EditText telefonoEt = findViewById(R.id.phoneEditText);
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
                String telefono = telefonoEt.getText().toString();
                String citta = cittaEt.getText().toString();

                Persona persona = new Persona();
                persona.setEmail(email);
                persona.setNome(nome);
                persona.setCognome(cognome);
                persona.setUsername(username);
                persona.setPassword(password);
                persona.setTelefono(telefono);
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
    }*/
