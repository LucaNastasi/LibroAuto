package fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import model.Pubblicazione;
import it.rizzoli.carbooklogin.PubblicazioneListAdapter;
import it.rizzoli.carbooklogin.R;

public class HomeFragment extends Fragment {
    Context ctx = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment

        ArrayList<Pubblicazione> lista = new ArrayList<>();
        lista.add(new Pubblicazione("Lamborghini miura fantastica ad un prezzo stracciato non fartela scappare!!!"));
        lista.add(new Pubblicazione("Ferrari enzo fiammante, non perdere l'occasione"));
        lista.add(new Pubblicazione("Fiat 500, super offerta!!!"));
        lista.add(new Pubblicazione("Mercedes classe AMG, fantastica"));

        PubblicazioneListAdapter pubblicazioneListAdapter = new PubblicazioneListAdapter(getActivity(), R.layout.rowlist_car_layout, lista);
        ListView pubblicazioneListView = view.findViewById(R.id.pubblicazioneListView);
        pubblicazioneListView.setAdapter(pubblicazioneListAdapter);
        return view;
    }

}
