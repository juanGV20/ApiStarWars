package com.aluracurso.apistarwars.tareas;

import com.aluracurso.apistarwars.modelos.PeliculaApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivos {
    List<PeliculaApi> listaConsulta = new ArrayList<>();

    public void guardarJson(PeliculaApi peliculaApi){
        listaConsulta.add(peliculaApi);
        System.out.println(listaConsulta);
    }

    public void exportarJson() throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter("PeliculasSTWars.json");
        escritura.write(gson.toJson(listaConsulta));
        escritura.close();
    }
}
