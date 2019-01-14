/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriadeconjuntos;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Tests by coti
 */
public class TeoriaDeConjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Este proyecto no hace nada, pero lo hace muy bien!
        Set<String> A, B, C;
        A = new TreeSet<String>();
        B = new TreeSet<String>();
        C = new TreeSet<String>();

        A.add("Santander");
        A.add("Burgos");
        A.add("Logroño");

        B.add("Logroño");
        B.add("Soria");
        B.add("Segovia");
        B.add("Ávila");

        C.addAll(A);
        C.addAll(B);
        System.out.println("La unión de " + A + " y " + B + " es " + C);

        C.clear();

        C.addAll(A);
        C.retainAll(B);

        System.out.println("La intersección de " + A + " y " + B + " es " + C);

        C.clear();

        C.addAll(A);
        C.removeAll(B);

        System.out.println("La diferencia de " + A + " con " + B + " (A-B) es " + C);

    }
}
