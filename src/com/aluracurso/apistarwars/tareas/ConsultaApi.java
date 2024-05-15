package com.aluracurso.apistarwars.tareas;

import com.aluracurso.apistarwars.modelos.PeliculaApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public PeliculaApi busquedaPelicula (int numeroDePelicula){

        URI direccion = URI.create("https://swapi.dev/api/films/" + numeroDePelicula + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), PeliculaApi.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro esa pelicula");
        }
    }
}
