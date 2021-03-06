package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import api.RetrofitClient;
import model.Pubblicazione;
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
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        textDate.setText(currentDate);
        String descrizione = editTextDescrivi.getText().toString().trim();

        if (descrizione.isEmpty()){
            editTextDescrivi.setError("Compila il campo richiesto");
            editTextDescrivi.requestFocus();
        }
        Call<Pubblicazione> call = RetrofitClient
                .getInstance()
                .getApiPubblicazione()
                .creaPubblicazione( currentDate, descrizione);
        call.enqueue(new Callback<Pubblicazione>() {
            @Override
            public void onResponse(Call<Pubblicazione> call, Response<Pubblicazione> response) {
                Pubblicazione p = response.body();
                Toast.makeText(AnnuncioRegistrazione.this, "Annuncio pubblicato", Toast.LENGTH_LONG).show();

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