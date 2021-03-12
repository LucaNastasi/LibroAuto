package it.rizzoli.carbooklogin.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.RegistazioneInferface;
import it.rizzoli.carbooklogin.model.Pubblicazione;
import it.rizzoli.carbooklogin.PubblicazioneListAdapter;
import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.model.listaPubblicazione;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    Context ctx = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ListView pubblicazioneListView = view.findViewById(R.id.pubblicazioneListView);

        ArrayList<Pubblicazione> lista = new ArrayList<>();
        lista.add(new Pubblicazione("Lamborghini miura fantastica ad un prezzo stracciato non fartela scappare!!!"));
        lista.add(new Pubblicazione("Ferrari enzo fiammante, non perdere l'occasione"));
        lista.add(new Pubblicazione("Fiat 500, super offerta!!!"));
        lista.add(new Pubblicazione("Mercedes classe AMG, fantastica"));

        ArrayList<listaPubblicazione> list = new ArrayList<>();

        RegistazioneInferface ri = RetrofitManager.retrofit.create(RegistazioneInferface.class);
        Call<ArrayList<listaPubblicazione>> call = ri.list();
        call.enqueue(new Callback<ArrayList<listaPubblicazione>>() {
            @Override
            public void onResponse(Call<ArrayList<listaPubblicazione>> call, Response<ArrayList<listaPubblicazione>> response) {
                if (response.code() == 200) {
                    ArrayList<listaPubblicazione> listRisposta = response.body();
                    list.addAll(listRisposta);
                    /*
                    PubblicazioneListAdapter pubblicazioneListAdapter1 = new PubblicazioneListAdapter(getActivity(), R.layout.rowlist_car_layout, list);
                    pubblicazioneListView.setAdapter(pubblicazioneListAdapter1);
                    */
                    Toast.makeText(getContext(), list.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<listaPubblicazione>> call, Throwable t) {

            }
        });

        PubblicazioneListAdapter pubblicazioneListAdapter = new PubblicazioneListAdapter(getActivity(), R.layout.rowlist_car_layout, lista);
        pubblicazioneListView.setAdapter(pubblicazioneListAdapter);
        return view;
    }

}
