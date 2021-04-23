package it.rizzoli.carbooklogin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.PersonaApi;
import it.rizzoli.carbooklogin.model.Persona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment implements View.OnClickListener {
    private EditText editTextUsername;


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        editTextUsername = view.findViewById(R.id.editTextTextPersonName);
        view.findViewById(R.id.buttonCercaNome).setOnClickListener(this);
        return view;
    }

    private void cercaUsername() {
        String username = editTextUsername.getText().toString().trim();

        PersonaApi personaApi = RetrofitManager.retrofit.create(PersonaApi.class);
        Call<Persona> cercaPersona = personaApi.byUsername(username);
        cercaPersona.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.code() == 200){
                    Persona p = response.body();
                    Toast.makeText(getActivity(), p.getNome(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCercaNome:
                cercaUsername();
        }
    }
}

