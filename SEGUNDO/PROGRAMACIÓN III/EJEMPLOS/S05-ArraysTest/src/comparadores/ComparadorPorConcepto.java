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
public class ComparadorPorConcepto implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        String concepto1 = fac1.getConcepto();
        String concepto2 = fac2.getConcepto();
        return concepto1.compareToIgnoreCase(concepto2);
    }

}
