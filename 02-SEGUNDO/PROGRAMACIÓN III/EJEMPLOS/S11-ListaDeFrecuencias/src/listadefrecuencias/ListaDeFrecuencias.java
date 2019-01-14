/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es.
 */
package listadefrecuencias;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author coti
 */
public class ListaDeFrecuencias {

    public static void main(String[] argumentos) {
        Map<String, Integer> mapa = new HashMap<>();
        //
        // Este programa recibe varias palabras a través de la línea de órdenes
        // Se cuentan los argumentos recibidos
        //
        if (argumentos.length == 0) {
            System.out.printf("%n%nNo se han recibido argumentos%n%n");
            return;
        }
        System.out.printf("%n%nRecuento de palabras%n%n");
        System.out.printf("La colección de palabras considerada es la siguiente:%n%n");
        //
        // Se muestra la lista de palabras recibidas
        // y al mismo tiempo se va incrementando su frecuencia
        //
        for (String palabra : argumentos) {
            //
            // Se muestran las palabras en una sola línea separadas por un espacio
            //
            System.out.printf(palabra + " ");
            //
            // Si la palabra aparece por primera vez, entonces su contador es null
            // luego se da al contador el valor 1.
            //
            // Si la palabra no aparece por primera vez, se añade 1 a su contador
            //
            // Se pone en el mapa la pareja (palabra, contador).
            //
            Integer contador = mapa.get(palabra);
            mapa.put(palabra, null == contador ? 1 : contador + 1);
        }
        System.out.printf("%n%n");
        //
        // Se muestra el número de palabras distintas
        //
        System.out.printf("Hay " + mapa.size() + " palabras distintas.%n%n");
        //
        // Se muestra la lista de palabras y frecuencias
        //
        mapa.keySet().forEach((s) -> {
            System.out.printf("La palabra %s aparece %d veces%n", s, mapa.get(s));
        });
        //
        // Se muestra el contenido del mapa
        //
        System.out.printf("%n%nEl contenido del mapa es el siguiente: ");
        System.out.println(mapa);
        
    }
}
