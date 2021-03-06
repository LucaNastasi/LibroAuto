package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import api.Api;
import api.RetrofitClient;
import it.rizzoli.carbooklogin.R;
import model.Persona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText, passwordEditText;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        findViewById(R.id.buttonAccedi).setOnClickListener(this);
        findViewById(R.id.buttonRegistrazione).setOnClickListener(this);

    }
    private void userLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        if (email.isEmpty()) {
            emailEditText.setError("L'email è obbligatoria");
            emailEditText.requestFocus();
            return;
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Inserisci email valida");
            emailEditText.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("La password è obbligatoria");
            passwordEditText.requestFocus();
            return;
        }
        if (password.length() < 6) {
            passwordEditText.setError("La password deve essere almeno di 6 caratteri");
            passwordEditText.requestFocus();
            return;
        }
         if (validateLogin(email, password)) {
             //do login
             doLogin(email, password);
         }
    }
    private boolean validateLogin(String email, String password){
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void doLogin(final String email,final String password){
        Call<Persona> call = RetrofitClient
                .getInstance()
                .getApi()
                .login(email,password);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.isSuccessful()){
                    Persona personaLoggata = response.body();
                    if(personaLoggata != null){
                        //login start main activity
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Login.this, "The email or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAccedi:
                userLogin();
                break;

            case R.id.buttonRegistrazione:
                Intent registratiIntent = new Intent(Login.this, Registrazione.class);
                startActivity(registratiIntent);
        }
    }
}

      /*Button registrazioneButton = findViewById(R.id.buttonRegistrazione);
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
        Button registrazioneButton = findViewById(R.id.buttonRegistrazione);
        registrazioneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registratiIntent = new Intent(Login.this, Registrazione.class);
                startActivity(registratiIntent);
            }
        });*/