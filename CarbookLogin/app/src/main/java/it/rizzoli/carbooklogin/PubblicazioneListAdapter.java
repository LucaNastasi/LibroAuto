package it.rizzoli.carbooklogin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import it.rizzoli.carbooklogin.activities.CommentiActivity;
import it.rizzoli.carbooklogin.model.Pubblicazione;
import it.rizzoli.carbooklogin.model.listaPubblicazione;

public class PubblicazioneListAdapter extends ArrayAdapter<listaPubblicazione> {
    Context ctx;
    int res;

    public PubblicazioneListAdapter(@NonNull Context context, int resource, ArrayList<listaPubblicazione> listaPubblicazioni) {
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
        ImageView imageProfilo = rowView.findViewById(R.id.imageProfilo);

        Button buttonCommenti = rowView.findViewById(R.id.buttonCommenti);
        //TextView textDescrizione = rowView.findViewById(R.id.textViewDescrizione);

        listaPubblicazione list = getItem(position);


        buttonCommenti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commentiActivity = new Intent(ctx, CommentiActivity.class);
                ctx.startActivity(commentiActivity);
            }
        });




       // textDescrizione.setText(p.getDescrizione());




        return rowView;
    }
}
