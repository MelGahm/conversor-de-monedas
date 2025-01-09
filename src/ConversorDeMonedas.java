import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMonedas {
    private static final String API_KEY = "8544e16dafe9d61a4a6e03b5"; // Tu API key
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double convertirUSD_A_ARS(double montoUSD) {
        double tasaDeCambio = obtenerTasaDeCambio("USD", "ARS");
        return montoUSD * tasaDeCambio;
    }

    public double convertirBRL_A_USD(double montoBRL) {
        double tasaDeCambio = obtenerTasaDeCambio("BRL", "USD");
        return montoBRL * tasaDeCambio;
    }

    public double convertirARS_A_USD(double montoARS) {
        double tasaDeCambio = obtenerTasaDeCambio("USD", "ARS");  // Obtenemos la tasa USD a ARS
        return montoARS / tasaDeCambio;  // Invertimos la tasa para obtener ARS a USD
    }

    private double obtenerTasaDeCambio(String monedaBase, String monedaDestino) {
        try {
            String url = API_URL + monedaBase + "?apikey=" + API_KEY;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parseamos el JSON de la respuesta
            Gson gson = new Gson();
            TasaCambio tasaCambio = gson.fromJson(response.body(), TasaCambio.class);

            // Extraemos la tasa de cambio de la respuesta JSON
            return tasaCambio.rates.get(monedaDestino);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
