/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package iteracion_frente_a_iniciacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author bruegel
 */
public class Iteracion_frente_a_Iniciacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] lista = new int[10];

        System.out.println("Lista inicial : " + Arrays.toString(lista));
        for (int n : lista) {
            n = 33;
        }
        System.out.println("Lista modificada: " + Arrays.toString(lista));

        List<String> coleccion = new ArrayList<>();
        coleccion.add("Adios");
        coleccion.add("Adios");
        coleccion.add("Adios");
        coleccion.add("Adios");
        System.out.println("Colección inicial : " + coleccion);
        for (String s : coleccion) {
            s = "Hola";
        }
        System.out.println("Colección modificada : " + coleccion);
        

    }

}
