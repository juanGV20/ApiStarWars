package com.aluracurso.apistarwars.principal;


import com.aluracurso.apistarwars.tareas.ConsultaApi;
import com.aluracurso.apistarwars.tareas.GeneradorDeArchivos;


import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();
        GeneradorDeArchivos generadorDeArchivos = new GeneradorDeArchivos();
        try {
            while (true) {
                System.out.println("Por favor digite el numero de la pelicula que desea consultar ");
                var busqueda = scanner.nextLine();
                if (busqueda.equalsIgnoreCase("salir")) {
                    break;
                }
                generadorDeArchivos.guardarJson(consultaApi.busquedaPelicula(Integer.parseInt(busqueda)));
            }
            generadorDeArchivos.exportarJson();
            System.out.println("Finalizo el programa");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizo el programa.");
        }
    }
}
