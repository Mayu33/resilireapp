package br.com.resilire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.resilire.prontuario.AdicionarFragment;
import br.com.resilire.prontuario.ListarFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarBancoDados();

        Button btnAdicionar = findViewById(R.id.button_AdicionarProntuario);
        Button btnListar = findViewById(R.id.button_ListarProntuario);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_prontuario, new ListarFragment()).commit();
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_prontuario, new ListarFragment()).commit();
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_prontuario, new AdicionarFragment()).commit();
            }
        });

    }

    private void criarBancoDados() {
        SQLiteDatabase db = openOrCreateDatabase("resilire.db", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS prontuario (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("nomePaciente VARCHAR(100), ");
        sql.append("observacao VARCHAR(500), ");
        sql.append("prescricao VARCHAR(300)");
        sql.append(");");

        sql.append("CREATE TABLE IF NOT EXISTS paciente (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("nome VARCHAR(100), ");
        sql.append("sexo VARCHAR(100), ");
        sql.append("email VARCHAR(100), ");
        sql.append("cpf VARCHAR(14), ");
        sql.append("cep VARCHAR(11)");
        sql.append("telefone VARCHAR(15)");
        sql.append(");");

        sql.append("CREATE TABLE IF NOT EXISTS consulta (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("data VARCHAR(30), ");
        sql.append("nomePaciente VARCHAR(100), ");
        sql.append("idProntuario VARCHAR(30), ");
        sql.append("idPsicologo VARCHAR(30), ");
        sql.append("status VARCHAR(11)");
        sql.append(");");

        try {
            String[] queries = sql.toString().split(";");
            for (String query : queries) {
                db.execSQL(query);
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        db.close();
    }
}