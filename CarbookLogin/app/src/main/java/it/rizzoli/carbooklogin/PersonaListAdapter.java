package it.rizzoli.carbooklogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import database.Persona;

public class PersonaListAdapter extends ArrayAdapter<Persona> {
    Context ctx;
    int res;

    public PersonaListAdapter(@NonNull Context context, int resource, ArrayList<Persona> persone) {
        super(context, resource);
        addAll(persone);

        ctx = context;
        res = resource;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(res, parent, false);

        TextView nameTextView = rowView.findViewById(R.id.nameTextView);
        TextView surnameTextView = rowView.findViewById(R.id.surnameTextView);
        TextView ageTextView = rowView.findViewById(R.id.ageTextView);

        Persona p = getItem(position);
        String eta = "" + p.getEta();

        nameTextView.setText(p.getNome());
        surnameTextView.setText(p.getCognome());
        ageTextView.setText(eta);

        return rowView;
    }
}
