package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.logo);
        TextView carbook = findViewById(R.id.carbook);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        TextView passwordDimenticata = findViewById(R.id.passwordDimenticata);
        Button accedi = findViewById(R.id.accedi);
        TextView copyright = findViewById(R.id.copyright);
        TextView registrazione = findViewById(R.id.registrazione);

    }





}