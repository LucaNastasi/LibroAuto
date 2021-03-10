package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import activities.Login;
import activities.Registrazione;
import api.RetrofitClient;
import it.rizzoli.carbooklogin.R;
import model.Automobile;
import model.Persona;
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
        }
        if(marca.isEmpty()){
            editTextMarca.setError("Compila questo campo");
            editTextMarca.requestFocus();
        }
        if(cambio.isEmpty()){
            editTextCambio.setError("Compila questo campo");
            editTextCambio.requestFocus();
        }
        if(alimentazione.isEmpty()){
            editTextCarburante.setError("Compila questo campo");
            editTextCarburante.requestFocus();
        }
        if(potenzaStr.isEmpty()){
            editTextPotenza.setError("Compila questo campo");
            editTextPotenza.requestFocus();
        }
        if(chilometraggioStr.isEmpty()){
            editTextChilometraggio.setError("Compila questo campo");
            editTextChilometraggio.requestFocus();
        }
        if(stato.isEmpty()){
            editTextStato.setError("Compila questo campo");
            editTextStato.requestFocus();
        }
        if(annoImmatricolazione.isEmpty()){
            editTextImmatricolazione.setError("Compila questo campo");
            editTextImmatricolazione.requestFocus();
        }
        if(prezzoStr.isEmpty()){
            editTextPrezzo.setError("Compila questo campo");
            editTextPrezzo.requestFocus();
        }
        if(citta.isEmpty()){
            editTextCitta.setError("Compila questo campo");
            editTextCitta.requestFocus();
        }
        Call<Automobile> call = RetrofitClient
                .getInstance()
                .getApi()
                .creaAutomobile(modello, stato, chilometraggioStr, alimentazione, cambio, potenzaStr, prezzoStr, marca, annoImmatricolazione, citta);
        call.enqueue(new Callback<Automobile>() {
            @Override
            public void onResponse(retrofit2.Call<Automobile> call, Response<Automobile> response) {
                Automobile s = response.body();
                //Toast.makeText(AddFragment.this, "L'auto è stata registrata", Toast.LENGTH_LONG).show();

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
