package it.rizzoli.carbooklogin.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import it.rizzoli.carbooklogin.Retrofit.RetrofitManager;
import it.rizzoli.carbooklogin.Retrofit.api.PubblicazioneApi;
import it.rizzoli.carbooklogin.adapter.ListaPubblicazioneListAdapter;
import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.model.ListaPubblicazione;
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

        ArrayList<ListaPubblicazione> list = new ArrayList<>();

        PubblicazioneApi pa = RetrofitManager.retrofit.create(PubblicazioneApi.class);
        Call<ArrayList<ListaPubblicazione>> call = pa.list();
        call.enqueue(new Callback<ArrayList<ListaPubblicazione>>() {
            @Override
            public void onResponse(Call<ArrayList<ListaPubblicazione>> call, Response<ArrayList<ListaPubblicazione>> response) {
                if (response.code() == 200) {
                    ArrayList<ListaPubblicazione> listRisposta = response.body();
                    list.addAll(listRisposta);

                    ListaPubblicazioneListAdapter listaPubblicazioneListAdapter = new ListaPubblicazioneListAdapter(getActivity(), R.layout.rowlist_car_layout, list);
                    pubblicazioneListView.setAdapter(listaPubblicazioneListAdapter);



                }
            }

            @Override
            public void onFailure(Call<ArrayList<ListaPubblicazione>> call, Throwable t) {
                Toast.makeText(getContext(), list.toString(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}






/* userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Utente ut = userListAdapter.getItem(i);
                String nominativo = ut.getCognome() + " " + ut.getNome();
                Toast.makeText(MainActivity.this, nominativo, Toast.LENGTH_LONG).show();
            }
        });*/





// Toast.makeText(getContext(), list.toString(), Toast.LENGTH_LONG).show();
