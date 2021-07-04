package br.com.resilire.webservice;
import android.os.AsyncTask;

//import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


// Classe não está sendo utilizada
public class GetCepHttpService extends AsyncTask<Void, Void, DadosEndereco> {

    private String cep;

    public GetCepHttpService(String cep) {
        this.cep = cep;
    }

    @Override
    protected DadosEndereco doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        String url_string = "https://viacep.com.br/ws/" + this.cep + "/json/";
        try {
            URL url = new URL(url_string);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); //Requisição para recuperação de dados
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.connect();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.nextLine());
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Gson gson = new Gson();
        //return gson.fromJson(resposta.toString(), DadosEndereco.class);
        return null;
    }
}
