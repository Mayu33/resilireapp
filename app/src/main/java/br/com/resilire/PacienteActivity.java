package br.com.resilire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.resilire.paciente.AdicionarFragment;
import br.com.resilire.paciente.ListarFragment;

public class PacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        Button btnAdicionar = findViewById(R.id.button_AdicionarPaciente);
        Button btnListar = findViewById(R.id.button_ListarPaciente);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_paciente, new ListarFragment()).commit();
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_paciente, new ListarFragment()).commit();
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_paciente, new AdicionarFragment()).commit();
            }
        });
    }
}