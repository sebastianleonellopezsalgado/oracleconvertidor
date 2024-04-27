import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ConvertidorMonedas {

    public static void main(String[] args) {
        boolean running = true;

        do {
            HashMap<Integer, String> convertidorMonedas = new HashMap<>();

            // Agregamos códigos de monedas
            convertidorMonedas.put(1, "USD");
            convertidorMonedas.put(2, "ARS");
            convertidorMonedas.put(3, "BRL");
            convertidorMonedas.put(4, "COP");
            convertidorMonedas.put(5, "MXN");

            int from, to;
            String fromCode, toCode;
            double amount;

            Scanner sc = new Scanner(System.in);

            System.out.println("Bienvenido al convertidor de monedas!");

            System.out.println("Convertidor de monedas DE");
            System.out.println("1:USD (US Dollar)\t 2:ARS (Peso Argentino )\t 3:BRL (Real Brasileño)\t 4:COP (Peso colombiano)\t 5:MXN (Peso mexicano) ");
            from = sc.nextInt();
            while (from < 1 || from > 5) {
                System.out.println("Por favor seleccione la opción correcta del convertidor (1-5)");
                from = sc.nextInt();
            }
            fromCode = convertidorMonedas.get(from);

            System.out.println("Convertidor de monedas A");
            System.out.println("1:USD (US Dollar)\t 2:ARS (Peso Argentino )\t 3:BRL (Real Brasileño)\t 4:COP (Peso colombiano)\t 5:MXN (Peso mexicano) ");
            to = sc.nextInt();
            while (to < 1 || to > 5) {
                System.out.println("Por favor seleccione la opción correcta del convertidor (1-5)");
                to = sc.nextInt();
            }
            toCode = convertidorMonedas.get(to);

            System.out.println("¿Qué cantidad desea convertir?");
            amount = sc.nextFloat();

            sendHttpGETRequest(fromCode, toCode, amount);

            System.out.println("¿Desea seguir usando el convertidor?");
            System.out.println("1: Si \t Cualquier número: No");
            if (sc.nextInt() != 1) {
                running = false;
            }
        } while (running);

        System.out.println("Gracias por usar el convertidor de monedas");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) {
        DecimalFormat f = new DecimalFormat("00.00");

        try {
            String GET_URL = "https://v6.exchangerate-api.com/v6/a81e1d2683c385621b090dea/latest/USD?base=" + fromCode + "&symbols=" + toCode;
            URL url = new URL(GET_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int resultCode = httpURLConnection.getResponseCode();

            if (resultCode == HttpURLConnection.HTTP_OK) { // éxito
                double exchangeRate = getExchangeRate(toCode, httpURLConnection);
                System.out.println(f.format(amount) + fromCode + " = " + f.format(amount * exchangeRate) + toCode);
            } else {
                System.out.println("GET respuesta fallida!");
            }
        } catch (IOException e) {
            System.out.println("Error al enviar la solicitud HTTP: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println("Error al analizar la respuesta JSON: " + e.getMessage());
        }
    }

    private static double getExchangeRate(String toCode, HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuilder result = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }
        in.close();

        JSONObject obj = new JSONObject(result.toString());
        JSONObject conversionRates = obj.getJSONObject("conversion_rates");
        return conversionRates.getDouble(toCode);
    }

}

