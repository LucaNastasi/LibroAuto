package com.example.registrazione;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nome= findViewById(R.id.nome);
        EditText cognome= findViewById(R.id.cognome);
        EditText email= findViewById(R.id.email);
        EditText username= findViewById(R.id.username);
        EditText password= findViewById(R.id.password);
        Button button = findViewById(R.id.button);
    }
}