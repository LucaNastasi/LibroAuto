package it.rizzoli.carbooklogin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import it.rizzoli.carbooklogin.fragments.HomeFragment;
import it.rizzoli.carbooklogin.model.ClasseCondivisa;
import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.PubblicazioneApi;
import it.rizzoli.carbooklogin.model.Pubblicazione;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnuncioRegistrazione extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextDescrivi;
    private TextView textDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annuncio_registrazione);

        editTextDescrivi = findViewById(R.id.editTextDescrivi);
        textDate = findViewById(R.id.textDate);
        findViewById(R.id.buttonAnnuncio).setOnClickListener(this);

    }
    private void registraAnnuncio(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = df.format(Calendar.getInstance().getTime());
        textDate.setText(currentDate);
        String descrizione = editTextDescrivi.getText().toString().trim();

        if (descrizione.isEmpty()){
            editTextDescrivi.setError("Compila il campo richiesto");
            editTextDescrivi.requestFocus();
            return;
        }

        Pubblicazione pubblicazione = new Pubblicazione();
        pubblicazione.setDataPubblicazione(currentDate);
        pubblicazione.setDescrizione(descrizione);
        pubblicazione.setAutomobile(ClasseCondivisa.automobileInserita);
        pubblicazione.setPersona(ClasseCondivisa.personaLoggata);

        PubblicazioneApi pa = RetrofitManager.retrofit.create(PubblicazioneApi.class);
        Call<Pubblicazione> nuovaPubblicazione = pa.nuovaPubblicazione(pubblicazione);
        nuovaPubblicazione.enqueue(new Callback<Pubblicazione>() {
            @Override
            public void onResponse(Call<Pubblicazione> call, Response<Pubblicazione> response) {
                if (response.code() == 200) {
                    Pubblicazione p = response.body();
                    Intent annuncioRegistrato = new Intent(AnnuncioRegistrazione.this, HomeFragment.class);
                    startActivity(annuncioRegistrato);
                }
            }

            @Override
            public void onFailure(Call<Pubblicazione> call, Throwable t) {
                Toast.makeText(AnnuncioRegistrazione.this, "Errore", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAnnuncio:
                registraAnnuncio();
                break;

        }
    }
}