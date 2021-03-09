package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import it.rizzoli.carbooklogin.R;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText editTextMarca, editTextModello, editTextCambio, editTextCarburante, editTextPotenza, editTextChilometraggio, editTextStato;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        editTextMarca = view.findViewById(R.id.editTextMarca);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
