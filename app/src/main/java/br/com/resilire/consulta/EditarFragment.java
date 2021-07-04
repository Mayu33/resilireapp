package br.com.resilire.consulta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import br.com.resilire.R;

// Edita consulta
public class EditarFragment extends Fragment {

    public EditarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editar_consulta, container, false);

        Bundle b = new Bundle();
        if (b != null) {
            b = getArguments();
            Toast.makeText(getContext(), "ID recebido: " + b.getString("id"), Toast.LENGTH_LONG).show();
        }

        Button btnEditar = (Button) v.findViewById(R.id.button_SalvarEditarConsulta);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicado no botão Salvar!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnExcluir = (Button) v.findViewById(R.id.button_ExcluirEditarConsulta);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicado no botão Excluir!", Toast.LENGTH_LONG).show();
            }
        });

        return v;
}

}
