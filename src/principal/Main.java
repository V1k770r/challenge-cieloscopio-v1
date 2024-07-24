package principal;

import com.google.gson.*;
import modelos.InformacionClima;
import modelos.InformacionClimaOpenWee;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String API_KEY = "01c9a3da1cb2d196a7eced3b1fd3a7f7";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) throws IOException, InterruptedException {

        int respuesta = 0;
        while (respuesta != 7) {
            System.out.println(
                    """
                            Challenge Cieloscopio:\s
                            ------------------------------------
                            Elige una ciudad para obtener los datos meteorológicos:\s
                            1. Ciudad de México \s
                            2. Buenos Aires\s
                            3. Bogotá\s
                            4. Lima\s
                            5. Santiago\s
                            6. Deseo consultar otra ciudad\s
                            7. Salir\s
                            ------------------------------------"""
            );

            System.out.println("Elige una opcion basada en el numero: ");
            Scanner lectura = new Scanner(System.in);

            try {
                respuesta = Integer.parseInt(lectura.nextLine());
            } catch (InputMismatchException  | NumberFormatException e ){
                System.out.println("Valor invalido");
            }

            switch (respuesta) {
                case 1 -> busquedaDeDatosPorCiudad("Ciudad de Mexico");
                case 2 -> busquedaDeDatosPorCiudad("Buenos Aires");
                case 3 -> busquedaDeDatosPorCiudad("Bogota");
                case 4 -> busquedaDeDatosPorCiudad("Lima");
                case 5 -> busquedaDeDatosPorCiudad("Santiago");
                case 6 -> {
                    System.out.println("Escriba el nombre de una ciudad: ");
                    var busquedaCiudad = lectura.nextLine();
                    busquedaDeDatosPorCiudad(busquedaCiudad);
                }
                case 7 -> {
                    System.out.println("Saliendo del programa Cieloscopio, gracias por usar nuestros servicios.");
                    break;
                }
                default -> {
                    System.out.println("Por favor, escoge una opcion correcta\n");
                }
            }
        }
    }

    private static void busquedaDeDatosPorCiudad(String ciudad) throws IOException, InterruptedException {

        ciudad = ciudad.replace(" ", "+");
        String direccion = BASE_URL + String.format("?q=%s&appid=%s&units=metric&lang=es", ciudad, API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        //System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting()
                .create();

        InformacionClimaOpenWee informacionClimaOpenWee = gson.fromJson(json,InformacionClimaOpenWee.class);


        InformacionClima informacionClima = new InformacionClima(informacionClimaOpenWee);
        System.out.println("La informacion del clima es: " + informacionClima);

   }
}