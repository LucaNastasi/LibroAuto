package it.rizzoli.carbooklogin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.model.ClasseCondivisa;

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
        return view;

    }
}
