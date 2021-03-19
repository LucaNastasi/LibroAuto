package it.rizzoli.carbooklogin.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import it.rizzoli.carbooklogin.R;
import it.rizzoli.carbooklogin.activities.CommentiActivity;
import it.rizzoli.carbooklogin.model.ListaPubblicazione;

public class ListaPubblicazioneListAdapter extends ArrayAdapter<ListaPubblicazione> {
    Context ctx;
    int res;

    public ListaPubblicazioneListAdapter(@NonNull Context context, int resource, ArrayList<ListaPubblicazione> listaPubblicazioni) {
        super(context, resource);
        addAll(listaPubblicazioni);

        ctx = context;
        res = resource;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(res, parent, false);


        ImageView imageViewMain = rowView.findViewById(R.id.imageViewMain);
        TextView marca = rowView.findViewById(R.id.marca);
        TextView modello = rowView.findViewById(R.id.modello);
        TextView costo = rowView.findViewById(R.id.prezzo);
        TextView chilometraggio = rowView.findViewById(R.id.textViewKm);
        TextView stato = rowView.findViewById(R.id.textStato);
        TextView alimentazione = rowView.findViewById(R.id.textAlimentazione);
        TextView potenza = rowView.findViewById(R.id.textCavalli);
        TextView dataPubblicazione = rowView.findViewById(R.id.textViewDate);
        TextView username = rowView.findViewById(R.id.textViewPersona);
        TextView telefono = rowView.findViewById(R.id.textViewTelefono);

        Button buttonCommenti = rowView.findViewById(R.id.buttonCommenti);

        ListaPubblicazione list = getItem(position);


        buttonCommenti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commentiActivity = new Intent(ctx, CommentiActivity.class);
                ctx.startActivity(commentiActivity);
            }
        });

        marca.setText(list.getMarca());
        modello.setText(list.getModello());
        costo.setText(list.getCosto().toString());
        chilometraggio.setText(list.getChilometraggio().toString());
        dataPubblicazione.setText(list.getDataPubblicazione());
        potenza.setText(list.getPotenza().toString());
        stato.setText(list.getStato());
        username.setText(list.getUsername());
        telefono.setText(list.getTelefono());
        alimentazione.setText(list.getAlimentazione());


        return rowView;
    }
}
