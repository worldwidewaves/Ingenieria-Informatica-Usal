/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
package arraystest;

import comparadores.*;
import java.util.Arrays;
import java.util.Comparator;
import static arraystest.Factura.*;

/*
 Modificado Nov 2014, removed unnecesary boxing
 */
/**
 *
 * @author bruegel
 */
public class ArraysTest {

    private static final String[] DIAS = {"Lunes", "Martes", "Miércoles",
        "Jueves",
        "Viernes", "Sábado", "Domingo"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Factura[] listaDeFacturas = new Factura[5];
        for (int i = 0; i < listaDeFacturas.length; i++) {
            listaDeFacturas[i] = new Factura();
            listaDeFacturas[i].setRandomAttributes();
        }
        // Ordenación de listas de String
        System.out.println("Lista original de String: ");
        showList2(DIAS);

        Arrays.sort(DIAS);
        System.out.println("Lista ordenada de String: ");
        showList(DIAS);
        
        System.out.println("Lista original de Facturas");
        Factura.showListAsTable(listaDeFacturas);
        //System.out.println(Arrays.toString(listaDeFacturas));
        
        System.out.println("Lista de Facturas ordenada por NIF");
        Comparator<Factura> comparadorPorNIF = new ComparadorPorNIF();
        Arrays.sort(listaDeFacturas, comparadorPorNIF);
        Factura.showListAsTable(listaDeFacturas);
        
        System.out.println("Está el DNI 222b en la lista?");
        String[] lista_de_nif = new String[listaDeFacturas.length];
        for (int i = 0; i < listaDeFacturas.length; i++) {
            lista_de_nif[i] = listaDeFacturas[i].getNIFdelReceptor();
        }
        String si_o_no = Arrays.binarySearch(lista_de_nif, "222b") >= 0 ? "SI" : "NO";
        System.out.println("El carnet " + si_o_no + " está en la lista.");
        
        System.out.println("Lista de Facturas ordenada por Importe");
        Comparator<Factura> comparadorImporte = new ComparadorPorImporte();
        Arrays.sort(listaDeFacturas, comparadorImporte);
        Factura.showListAsTable(listaDeFacturas);
    } // fin de main

} // fin de ArrayTest
