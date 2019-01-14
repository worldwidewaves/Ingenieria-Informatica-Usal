/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparadores;

import arraystest.Factura;
import java.util.Comparator;

/**
 *
 * @author coti
 */
public class ComparadorPorNombre implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        String nombre1 = fac1.getNombreReceptor();
        String nombre2 = fac2.getNombreReceptor();
        return nombre1.compareToIgnoreCase(nombre2);
    }

}
