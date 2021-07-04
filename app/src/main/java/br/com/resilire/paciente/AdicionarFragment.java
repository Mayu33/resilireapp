package br.com.resilire.paciente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import br.com.resilire.R;

// Adiciona um paciente
public class AdicionarFragment extends Fragment {

    public AdicionarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adicionar_paciente, container, false);
        Button btn = (Button) v.findViewById(R.id.button_SalvarAdicionarPaciente);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicado no botão Salvar!", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

}
