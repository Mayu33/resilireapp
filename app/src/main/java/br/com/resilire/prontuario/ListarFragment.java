package br.com.resilire.prontuario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.resilire.R;

// Lista os prontuários
public class ListarFragment extends Fragment {

    public ListarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listar_prontuario, container, false);

        ListView lv = (ListView) v.findViewById(R.id.listView_prontuario);

        List<String> lista_prontuarios = new ArrayList<String>();
        lista_prontuarios.add("Prontuario 1");
        lista_prontuarios.add("Prontuario 2");
        lista_prontuarios.add("Prontuario 3");
        lista_prontuarios.add("Prontuario 4");
        lista_prontuarios.add("Prontuario 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                lista_prontuarios
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putString("id", "2");

                EditarFragment f = new EditarFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                f.setArguments(b);
                ft.replace(R.id.frame_prontuario, f);
                ft.commit();
            }
        });

        return v;
    }
}
