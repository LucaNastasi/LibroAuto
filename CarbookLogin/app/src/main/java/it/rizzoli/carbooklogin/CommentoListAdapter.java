package it.rizzoli.carbooklogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import database.Commento;


public class CommentoListAdapter extends ArrayAdapter<Commento> {
    Context ctx;
    int res;

    public CommentoListAdapter(@NonNull Context context, int resource, ArrayList<Commento> commenti) {
        super(context, resource);
        addAll(commenti);

        ctx = context;
        res = resource;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(res, parent, false);
        ImageView imageProfilo = rowView.findViewById(R.id.imageProfilo);
        TextView textNome = rowView.findViewById(R.id.textNome);
        TextView textCommento = rowView.findViewById(R.id.textCommento);

        Commento c = getItem(position);



        textNome.setText(c.getNomeUtente());
        textCommento.setText(c.getContenutoCommento());


        return rowView;
    }
}
