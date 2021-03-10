package fragments;

import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import api.RetrofitClient;
import it.rizzoli.carbooklogin.R;
import model.Automobile;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText editTextMarca, editTextModello, editTextCambio, editTextCarburante, editTextPotenza, editTextChilometraggio, editTextStato;

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
        view.findViewById(R.id.buttonAuto).setOnClickListener(this);

        return view;
    }

    private void registraAuto(){
        String marca = editTextMarca.getText().toString().trim();
        String modello = editTextModello.getText().toString().trim();
        String cambio = editTextCambio.getText().toString().trim();
        String carburante = editTextCarburante.getText().toString().trim();
        String potenza = editTextPotenza.getText().toString().trim();
        String chilometraggio = editTextChilometraggio.getText().toString().trim();
        String stato = editTextStato.getText().toString().trim();

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
        if(carburante.isEmpty()){
            editTextCarburante.setError("Compila questo campo");
            editTextCarburante.requestFocus();
        }
        if(potenza.isEmpty()){
            editTextPotenza.setError("Compila questo campo");
            editTextPotenza.requestFocus();
        }
        if(chilometraggio.isEmpty()){
            editTextChilometraggio.setError("Compila questo campo");
            editTextChilometraggio.requestFocus();
        }
        if(stato.isEmpty()){
            editTextStato.setError("Compila questo campo");
            editTextStato.requestFocus();
        }
        Call<Automobile> call = RetrofitClient
                .getInstance()
                .getApi()
                .creaAutomobile(marca, modello)

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
