package arraystest;

import comparadores.ComparadorPorImporte;
import comparadores.ComparadorPorNIF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author bruegel
 */
public class ArrayListTest {

    public static void showList(ArrayList<String> _lista) {
        if (_lista == null) {
            System.err.println("Lista null!!!");
            return;
        }
        if (_lista.isEmpty()) {
            System.err.println("Lista vacía!!!");
            return;
        }
        System.out.printf("{ %s", _lista.get(0));
        for (int i = 1; i < _lista.size(); i++) {
            System.out.printf(", %s", _lista.get(i));
        }
        System.out.printf(" }%n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<>();
        String[] lista = {"Lunes", "Martes", "Miércoles",
            "Jueves",
            "Viernes", "Sábado", "Domingo"};
        Collections.addAll(dias, lista);
        ArrayList<Factura> listaFac = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Factura f = new Factura();
            f.setRandomAttributes();
            listaFac.add(f);
        }
        // Ordenación de listas de String
        System.out.println("Lista original de String: ");
        showList(dias);
        Collections.sort(dias);
        System.out.println("Lista ordenada de String: ");
        showList(dias);
        System.out.println("Lista original de Facturas");
        Factura.showListAsTable(listaFac);
        System.out.println("Lista de Facturas ordenada por NIF");
        Comparator<Factura> comparadorPorNIF = new ComparadorPorNIF();
        Collections.sort(listaFac, comparadorPorNIF);
        Factura.showListAsTable(listaFac);
        System.out.println("Está el DNI 222b en la lista?");
        ArrayList<String> lista_de_nif = new ArrayList<>();
        for (Factura f : listaFac) {
            lista_de_nif.add(f.getNIF());
        }
        String si_o_no = Collections.binarySearch(lista_de_nif, "222b") >= 0 ? "SI" : "NO";
        System.out.println("El carnet " + si_o_no + " está en la lista.");
        System.out.println("Lista de Facturas ordenada por Importe");
        Comparator<Factura> comparadorImporte = new ComparadorPorImporte();
        Collections.sort(listaFac, comparadorImporte);
        Factura.showListAsTable(listaFac);
    } // fin de main

} // fin de ArrayTest
