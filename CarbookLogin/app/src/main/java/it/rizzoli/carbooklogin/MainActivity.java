package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import database.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Antonio", "Lezzi", 27, "ciao@info"));
        lista.add(new Persona("Pippo", "Pluto", 37, "ciao@info"));
        lista.add(new Persona("Mario", "Rossi", 47, "ciao@info"));
        lista.add(new Persona("Giuseppe", "Verdi", 57, "ciao@info"));

        PersonaListAdapter personaListAdapter = new PersonaListAdapter(this, R.layout.rowlist_main, lista);
        ListView personaListView = findViewById(R.id.personaListView);
        personaListView.setAdapter(personaListAdapter);


        personaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Persona p = personaListAdapter.getItem(i);
                String nominativo = p.getCognome() + " " + p.getNome();
                Toast.makeText(MainActivity.this, nominativo, Toast.LENGTH_LONG).show();
            }
        });

    }
}