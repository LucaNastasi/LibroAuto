package it.rizzoli.carbooklogin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import it.rizzoli.carbooklogin.model.ClasseCondivisa;
import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.AutomobileApi;
import it.rizzoli.carbooklogin.activities.RegistraAutoSplash;
import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.model.Automobile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText editTextMarca, editTextModello, editTextCambio, editTextCarburante, editTextPotenza, editTextChilometraggio, editTextStato, editTextImmatricolazione, editTextPrezzo, editTextCitta;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        editTextMarca = view.findViewById(R.id.editTextMarca);
        editTextModello = view.findViewById(R.id.editTextModello);
        editTextCambio = view.findViewById(R.id.editTextCambio);
        editTextCarburante = view.findViewById(R.id.editTextCarburante);
        editTextPotenza = view.findViewById(R.id.editTextPotenza);
        editTextChilometraggio = view.findViewById(R.id.editTextChilometraggio);
        editTextStato = view.findViewById(R.id.editTextStato);
        editTextImmatricolazione = view.findViewById(R.id.editTextImmatricolazione);
        editTextPrezzo= view.findViewById(R.id.editTextPrezzo);
        editTextCitta = view.findViewById(R.id.editTextCitta);
        view.findViewById(R.id.buttonAuto).setOnClickListener(this);

        return view;
    }

    private void registraAuto(){
        String marca = editTextMarca.getText().toString().trim();
        String modello = editTextModello.getText().toString().trim();
        String cambio = editTextCambio.getText().toString().trim();
        String alimentazione = editTextCarburante.getText().toString().trim();
        String potenzaStr = editTextPotenza.getText().toString().trim();
        Integer potenza = Integer.parseInt(potenzaStr);
        String chilometraggioStr= editTextChilometraggio.getText().toString().trim();
        Integer chilometraggio = Integer.parseInt(chilometraggioStr);
        String stato = editTextStato.getText().toString().trim();
        String annoImmatricolazione = editTextImmatricolazione.getText().toString().trim();
        String prezzoStr = editTextPrezzo.getText().toString().trim();
        Integer prezzo = Integer.parseInt(prezzoStr);
        String citta = editTextCitta.getText().toString().trim();


        if(modello.isEmpty()){
            editTextModello.setError("Compila questo campo");
            editTextModello.requestFocus();
            return;
        }
        if(marca.isEmpty()){
            editTextMarca.setError("Compila questo campo");
            editTextMarca.requestFocus();
            return;
        }
        if(cambio.isEmpty()){
            editTextCambio.setError("Compila questo campo");
            editTextCambio.requestFocus();
            return;
        }
        if(alimentazione.isEmpty()){
            editTextCarburante.setError("Compila questo campo");
            editTextCarburante.requestFocus();
            return;
        }
        if(potenzaStr.isEmpty()){
            editTextPotenza.setError("Compila questo campo");
            editTextPotenza.requestFocus();
            return;
        }
        if(chilometraggioStr.isEmpty()){
            editTextChilometraggio.setError("Compila questo campo");
            editTextChilometraggio.requestFocus();
            return;
        }
        if(stato.isEmpty()){
            editTextStato.setError("Compila questo campo");
            editTextStato.requestFocus();
            return;
        }
        if(annoImmatricolazione.isEmpty()){
            editTextImmatricolazione.setError("Compila questo campo");
            editTextImmatricolazione.requestFocus();
            return;
        }
        if(prezzoStr.isEmpty()){
            editTextPrezzo.setError("Compila questo campo");
            editTextPrezzo.requestFocus();
            return;
        }
        if(citta.isEmpty()){
            editTextCitta.setError("Compila questo campo");
            editTextCitta.requestFocus();
            return;
        }


        Automobile a = new Automobile();
        a.setAlimentazione(alimentazione);
        a.setAnnoImmatricolazione(annoImmatricolazione);
        a.setChilometraggio(chilometraggio);
        a.setCitta(citta);
        a.setModello(modello);
        a.setPotenza(potenza);
        a.setCosto(prezzo);
        a.setStato(stato);
        a.setCambio(cambio);
        a.setMarca(marca);

        AutomobileApi autoApi = RetrofitManager.retrofit.create(AutomobileApi.class);
        Call<Automobile> nuovaAutomobile = autoApi.nuovaAutomobile(a);
        nuovaAutomobile.enqueue(new Callback<Automobile>() {
            @Override
            public void onResponse(retrofit2.Call<Automobile> call, Response<Automobile> response) {
                if (response.code() == 200) {
                    Automobile a = response.body();
                    ClasseCondivisa.automobileInserita = a;
                    Toast.makeText(getActivity(), "L'auto è stata registrata", Toast.LENGTH_LONG).show();
                    Intent splashRegistra = new Intent(getActivity(), RegistraAutoSplash.class);
                    startActivity(splashRegistra);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Automobile> call, Throwable t) {
                Toast.makeText(getActivity(), "Errore", Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAuto:
                registraAuto();
                break;
        }
    }
}
