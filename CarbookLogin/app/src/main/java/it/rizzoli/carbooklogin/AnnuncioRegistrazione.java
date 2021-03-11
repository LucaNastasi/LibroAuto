package it.rizzoli.carbooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

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
        String

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