package it.rizzoli.carbooklogin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import it.rizzoli.carbooklogin.adapter.CommentoListAdapter;
import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.model.Commento;

public class CommentiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commenti);

        ArrayList<Commento> lista = new ArrayList<>();
        lista.add(new Commento("Luca Nastasi", "wow auto fantastica"));
        lista.add(new Commento("Marco Picuno", "Che mezzo!!!!!!"));
        lista.add(new Commento("Simone Venegoni", "Non male ma non batte la mia f40"));
        lista.add(new Commento("Daniele Consonni", "Io si che ho i soldi"));

        CommentoListAdapter commentoListAdapter = new CommentoListAdapter(this, R.layout.rowlist_commenti_layout, lista);
        ListView commentoListView = findViewById(R.id.commentoListView);
        commentoListView.setAdapter(commentoListAdapter);

    }
}