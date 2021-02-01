package it.rizzoli.eventi2schermata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titolo = findViewById(R.id.titolo);
        TextView descrizione = findViewById(R.id.descrizione);
        ImageView immagineprincipale = findViewById(R.id.immagineprincipale);
        ImageView immagine1 = findViewById(R.id.immagine1);
        ImageView immagine2 = findViewById(R.id.immagine2);
        ImageView immagine13= findViewById(R.id.immagine3);
        ImageView immagine4 = findViewById(R.id.immagine4);
        TextView valutazione = findViewById(R.id.valutazione);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView date = findViewById(R.id.date);
        TextView datequando = findViewById(R.id.quandodate);
        TextView where = findViewById(R.id.whereluogo);







    }



}