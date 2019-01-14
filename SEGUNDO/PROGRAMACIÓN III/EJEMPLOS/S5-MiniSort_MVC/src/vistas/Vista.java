/**
 *
 * @author bruegel
 */
package vistas;

import datos.Modelo;
import java.util.Arrays;
import datos.MiniPersona;

public class Vista {

    Modelo m;

    public Vista(Modelo _m) {
        this.m = _m;
    } // fin Constructor

    public void verListaAleatoria() {
        m.crearListaAleatoria();
        System.out.printf("%nLista aleatoria%n");
        this.mostrarListado();
    }

    public void mostrarListado() {
        String separador = "+------------"
                + "+-----+"
                +"+------";
        for (MiniPersona miniPersona : m.getMiniLista()) {
            System.out.println(separador);
            System.out.printf("| %-10s | %3d | %4.2f |%n",
                    miniPersona.getNombre(),
                    miniPersona.getEdad()
            ,miniPersona.getPeso());
        }
        System.out.println(separador);
    }

    public void ordenarPorNombres() {
        System.out.printf("%nContenido de la lista después de ordenarla por nombres:%n%n");
        Arrays.sort(m.getMiniLista(), m.getComparadorPorNombres());
        this.mostrarListado();
    }

    public void ordenarPorEdades() {
        System.out.printf("%nContenido de la lista después de ordenarla por edades:%n%n");
        Arrays.sort(m.getMiniLista(), m.getComparadorPorEdades());
        this.mostrarListado();
    }

    public void ordenarPorPesos() {
       System.out.printf("%nContenido de la lista después de ordenarla por pesos:%n%n");
        Arrays.sort(m.getMiniLista(), m.getComparadorPorPesos());
        this.mostrarListado();
    }

} // fin Vista

