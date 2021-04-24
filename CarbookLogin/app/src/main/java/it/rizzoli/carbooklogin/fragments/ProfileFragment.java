package it.rizzoli.carbooklogin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.PubblicazioneApi;
import it.rizzoli.carbooklogin.activities.Login;
import it.rizzoli.carbooklogin.model.ClasseCondivisa;
import it.rizzoli.carbooklogin.model.Pubblicazione;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView usernameTxt= view.findViewById(R.id.username);
        TextView nomeTxt = view.findViewById(R.id.nome);
        TextView cognomeTxt = view.findViewById(R.id.cognome);
        TextView emailTxt = view.findViewById(R.id.email);
        TextView telefonoTxt = view.findViewById(R.id.telefono);


        usernameTxt.setText(ClasseCondivisa.personaLoggata.getUsername());
        nomeTxt.setText(ClasseCondivisa.personaLoggata.getNome());
        cognomeTxt.setText(ClasseCondivisa.personaLoggata.getCognome());
        emailTxt.setText(ClasseCondivisa.personaLoggata.getEmail());
        telefonoTxt.setText(ClasseCondivisa.personaLoggata.getTelefono());



        ImageButton logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getActivity(), Login.class);
                startActivity(logout);
                pubblicazioneUser();

            }

            private void pubblicazioneUser() {
                PubblicazioneApi pubblicazioneApi = RetrofitManager.retrofit.create(PubblicazioneApi.class);
                Call<List<Pubblicazione>> byUser = pubblicazioneApi.byPersona(ClasseCondivisa.personaLoggata);
                byUser.enqueue(new Callback<List<Pubblicazione>>() {
                    @Override
                    public void onResponse(Call<List<Pubblicazione>> call, Response<List<Pubblicazione>> response) {
                        if(response.code() == 200){
                            List<Pubblicazione> risposta = response.body();
                            Toast.makeText(getContext(), (CharSequence) risposta, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Pubblicazione>> call, Throwable t) {

                    }
                });
            }
        });

        return view;


    }
}
