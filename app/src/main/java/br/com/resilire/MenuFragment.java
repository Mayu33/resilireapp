package br.com.resilire;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MenuFragment extends Fragment {

    public MenuFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_prontuario:
                Intent prontuario = new Intent(getContext(), MainActivity.class);
                startActivity(prontuario);
                break;
            case R.id.menu_paciente:
                Intent paciente = new Intent(getContext(), PacienteActivity.class);
                startActivity(paciente);
                break;
            case R.id.menu_consulta:
                Intent consulta = new Intent(getContext(), ConsultaActivity.class);
                startActivity(consulta);
                break;
            case R.id.menu_sensor:
                Intent sensor = new Intent(getContext(), SensorActivity.class);
                startActivity(sensor);
                break;
            case R.id.menu_camera:
                Intent camera = new Intent(getContext(), CameraActivity.class);
                startActivity(camera);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}