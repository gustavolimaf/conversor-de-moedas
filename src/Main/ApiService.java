package Main;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    // Sua chave de API (você pode depois externalizar para uma variável de ambiente ou arquivo, mas por enquanto deixamos aqui)
    private static final String API_KEY = "fd2b4e8e95d84d5172b85f4f";

    /**
     * Faz a requisição à ExchangeRate-API para obter a taxa de conversão entre duas moedas.
     * Se tudo der certo, retorna um Double com o valor da taxa; caso contrário, retorna null.
     */
    public Double obterTaxa(String from, String to) {
        try {
            // Monta a URL final, substuindo {API_KEY}, {from} e {to}
            String endpoint = String.format(
                    "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                    API_KEY, from, to
            );

            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);   // timeout de conexão em 5 segundos
            connection.setReadTimeout(5000);      // timeout de leitura em 5 segundos

            int status = connection.getResponseCode();
            if (status == 200) {
                // Se o status HTTP == 200 (OK), lemos o corpo da resposta
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());

                // Usa o Gson para converter de JSON para ExchangeRateResponse
                ExchangeRateResponse resposta = new Gson().fromJson(reader, ExchangeRateResponse.class);

                reader.close();
                connection.disconnect();

                // Retorna apenas o campo conversion_rate
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
