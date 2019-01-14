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
public class ComparadorPorImporte implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        Float importe1 = fac1.getImporte();
        Float importe2 = fac2.getImporte();
        return importe1.compareTo(importe2);
    }

}
