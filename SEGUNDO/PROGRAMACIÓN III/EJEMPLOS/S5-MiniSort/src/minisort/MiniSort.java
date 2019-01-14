/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minisort;

import java.util.Arrays;
import java.util.Comparator;
import minipaquete.MiniPersona;

/**
 *
 * @author bruegel
 */
public class MiniSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MiniPersona[] miniLista = new MiniPersona[4];
        for (int i = 0; i < miniLista.length; i++) {
            miniLista[i] = new MiniPersona();
            miniLista[i].miniSetRandomAttributes();
        }
        System.out.printf("%nContenido de la lista antes de ordenarla:%n%n");
        Comparator<MiniPersona> comparadorPorNombres = new ComparadorPorNombres();
        MiniPersona.mostrarListaDeMiniPersonas(miniLista);
        Arrays.sort(miniLista, comparadorPorNombres);
        System.out.printf("%nContenido de la lista después de ordenarla por nombres:%n%n");
        MiniPersona.mostrarListaDeMiniPersonas(miniLista);
        System.out.printf("%nContenido de la lista después de ordenarla por edades:%n%n");
        Comparator<MiniPersona> comparadorPorEdades = new ComparadorPorEdades();
        Arrays.sort(miniLista, comparadorPorEdades);
        MiniPersona.mostrarListaDeMiniPersonas(miniLista);

    }

}
