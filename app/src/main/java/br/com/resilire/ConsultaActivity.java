package br.com.resilire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.resilire.consulta.AdicionarFragment;
import br.com.resilire.consulta.ListarFragment;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        Button btnAdicionar = findViewById(R.id.button_AdicionarConsulta);
        Button btnListar = findViewById(R.id.button_ListarConsulta);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_consulta, new ListarFragment()).commit();
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_consulta, new ListarFragment()).commit();
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_consulta, new AdicionarFragment()).commit();
            }
        });

    }
}