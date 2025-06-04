package Main;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    private static final String API_KEY = "chave-api-pessoal";

    public Double obterTaxa(String from, String to) {
        try {

            String endpoint = String.format(
                    "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                    API_KEY, from, to
            );

            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);   
            connection.setReadTimeout(5000);      

            int status = connection.getResponseCode();
            if (status == 200) {

                InputStreamReader reader = new InputStreamReader(connection.getInputStream());

                ExchangeRateResponse resposta = new Gson().fromJson(reader, ExchangeRateResponse.class);

                reader.close();
                connection.disconnect();

                return resposta.conversion_rate;
            } else {
                System.err.println("Erro HTTP ao chamar ExchangeRate-API. Código: " + status);
                connection.disconnect();
                return null;
            }

        } catch (Exception e) {
            System.err.println("Erro ao chamar API: " + e.getMessage());
            return null;
        }
    }
}
