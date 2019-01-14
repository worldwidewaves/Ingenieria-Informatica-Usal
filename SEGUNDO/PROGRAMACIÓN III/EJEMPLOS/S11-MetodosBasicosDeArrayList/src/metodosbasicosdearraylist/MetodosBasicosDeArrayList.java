/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package metodosbasicosdearraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author bruegel
 */
public class MetodosBasicosDeArrayList {

    List<String> lista;

    public MetodosBasicosDeArrayList() {
        lista = new ArrayList<>();
        lista.add("Winter");
        lista.add("is");
        lista.add("coming");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MetodosBasicosDeArrayList mba = new MetodosBasicosDeArrayList();
        System.out.printf("%nList<E> - métodos básicos%n%n");
        System.out.println("La lista es " + mba.lista);

        mba.acceso();
        mba.adicion();
        mba.insercion();
        mba.adicionDeColeccion();
        mba.busqueda();
        mba.eliminacionPorIteracion();
        mba.sublistas();
    }

    private void acceso() {
        System.out.printf("%nMétodos de acceso%n");
        System.out.printf("%nRecorrido de la lista con índices%n");
        //
        // Acceder al valor del i-eximo elemento, lista.get(i)
        //
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("lista.get(%d) = %s%n", i, lista.get(i));
        }
        //
        // Modificar el valor del i-ésimo elemento, lista.set(i)
        //
        lista.set(2, "here");
        System.out.printf("%nDespués de ejecutar"
                + " lista.set(2,\"here\"); la lista es%n");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("lista.get(%d) = %s%n", i, lista.get(i));
        }
        lista.set(2, "here");

    }

    private void adicion() {
        System.out.printf("%nMétodos de adición%n==================%n%n");
        System.out.printf("");
        lista.clear();
        //
        // Adición al final
        //
        lista.add("Ours");
        lista.add("is");
        System.out.println("Lista inicial " + lista);
        lista.add("the");
        lista.add("Fury");
        System.out.println("\nLista con adiciones al final " + lista);

    }

    private void insercion() {
        //
        // Inserción en posición intermedia
        //
        System.out.printf("%nMétodos de inserción%n====================%n%n");
        lista.clear();
        System.out.println("Lista inicial " + lista);
        lista.add("sword");
        lista.add(0, "am");
        lista.add(0, "I");
        lista.add(2, "the");
        lista.add("night");
        lista.add(4, "in");
        lista.add(5, "the");
        //
        // No se puede insertar mas alla de los límites de la lista
        //
        //lista.add(33,"wailing");

        System.out.printf("%nLista tras las inserciones: ");
        System.out.println(lista);
    }

    private void adicionDeColeccion() {
        System.out.printf("%nAñadir una colección%n====================%n%n");
        lista.clear();
        lista.add("Night");
        lista.add("is");
        lista.add("dark");
        System.out.println("Lista inicial: " + lista);
        List<String> otraColeccion = new ArrayList<>();
        otraColeccion.add(",");
        otraColeccion.add("and");
        otraColeccion.add("full");
        otraColeccion.add("of");
        otraColeccion.add("horrors.");
        lista.addAll(otraColeccion);
        System.out.println("Lista añadida:" + otraColeccion);
        System.out.println("Lista final: " + lista);
    }

    private void busqueda() {
        System.out.printf("%nMétodos de búsqueda%n===================%n%n");
        lista.clear();
        lista.add("Unbowed");
        lista.add(",");
        lista.add("Unbent");
        lista.add(",");
        lista.add("unbroken");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("lista[%d] = \"%s\"%n", i, lista.get(i));
        }
        int pos1 = lista.indexOf(",");
        int pos2 = lista.lastIndexOf(",");
        System.out.printf("%nPosiciones de \",\" dentro de la lista:%n%n");
        System.out.printf("lista.indexOf(\",\") = %d%n", pos1);
        System.out.printf("lista.lastIndexOf(\",\") = %d%n", pos2);
    }

    private void eliminacionPorIteracion() {
        System.out.printf("%nEliminación de elementos%n=========================%n%n");
        System.out.printf("Lista original%n%n");
        lista.clear();
        lista.add("Unbowed");
        lista.add(",");
        lista.add("Unbent");
        lista.add(",");
        lista.add("unbroken");
        ListIterator<String> li = lista.listIterator();
        while (li.hasNext()) {
            System.out.printf("Element number %d is %s%n", li.nextIndex(), li.next());
        }
        li = lista.listIterator();
        System.out.printf("%nEliminación de las comas%n%n");
        while (li.hasNext()) {
            if (li.next().equalsIgnoreCase(",")) {
                li.remove();
            }
        }
        System.out.printf("Lista modificada%n%n");
        li = lista.listIterator();
        while (li.hasNext()) {
            System.out.printf("Element number %d is %s%n", li.nextIndex(), li.next());
        }
    }

    private void sublistas() {
        System.out.printf("%nCreación de sublistas%n=====================%n%n");
        List<String> got = new ArrayList<>();
        String[] array = "Night is dark and full of horrors".split(" ");
        Collections.addAll(got, array);
        System.out.printf("%nLista original: %s%n", got);
        //
        // sublist(start, end) does not include end
        //
        List<String> sublist = got.subList(0, got.indexOf("and"));
        System.out.printf("%nSublista: %s%n", sublist);

    }

}
