/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Los datos pasados a través de la línea de órdenes son diccionario.txt y 6.
 * 
 */
package tabladispersiva_y_sort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author coti
 */
public class TablaDispersiva_y_Sort {

    private static String alfabetizar(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);

    }

    public static void main(String[] args) {
        int longitudGrupoMinima = Integer.parseInt(args[1]);

        // Se leen las palabras y se ponen en un multimapa, esto es,
        Map<String, List<String>> multiMapa = new HashMap<String, List<String>>();
        try {
            Scanner s = new Scanner(new File(args[0]));
            while (s.hasNext()) {
                String palabra = s.next();
                String caracteresDePalabraPorOrdenAlfabetico = alfabetizar(palabra);
                List<String> listaDeAnagramas = multiMapa.get(caracteresDePalabraPorOrdenAlfabetico);
                if (listaDeAnagramas == null) {
                    multiMapa.put(caracteresDePalabraPorOrdenAlfabetico, listaDeAnagramas = new ArrayList<String>());
                }
                listaDeAnagramas.add(palabra);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        // Se crea una lista formada por aquellas listas que contienen como minimo
        // longitudGrupoMinima anagramas

        List<List<String>> listasDeAnagramasValidas = new ArrayList<List<String>>();
        for (List<String> listaDeAnagramasEstudiada : multiMapa.values()) {
            if (listaDeAnagramasEstudiada.size() >= longitudGrupoMinima) {
                listasDeAnagramasValidas.add(listaDeAnagramasEstudiada);
            }
        }

        // Se ordena la lista de listas longitudes de las listas
        Collections.sort(listasDeAnagramasValidas, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o2.size() - o1.size();
            }
        });

        // Se imprimen las listas de anagramas con sus longitudes
        for (List<String> anagrama : listasDeAnagramasValidas) {
            System.out.println(anagrama.size() + ": " + anagrama);
        }
    }
}