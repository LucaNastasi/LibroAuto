package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import database.Persona;
import database.Pubblicazione;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pubblicazione> lista = new ArrayList<>();
        lista.add(new Pubblicazione("Luca Nastasi", "Lamborghini miura fantastica auto, rispecchia in pieno lo stile della casa"));
        lista.add(new Pubblicazione("Marco Picuno", "Ferrari enzo"));
        lista.add(new Pubblicazione("Simone Venegoni", "F40"));
        lista.add(new Pubblicazione("Daniele Consonni", "Pagani zonda"));

        PubblicazioneListAdapter pubblicazioneListAdapter = new PubblicazioneListAdapter(this, R.layout.rowlist_car_layout, lista);
        ListView pubblicazioneListView = findViewById(R.id.pubblicazioneListView);
        pubblicazioneListView.setAdapter(pubblicazioneListAdapter);



    }
}