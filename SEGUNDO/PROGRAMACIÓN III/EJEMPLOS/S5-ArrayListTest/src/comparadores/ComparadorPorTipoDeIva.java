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
public class ComparadorPorTipoDeIva implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        Float iva1 = new Float(fac1.getTipo_de_IVA());
        Float iva2 = new Float(fac2.getTipo_de_IVA());
        return iva1.compareTo(iva2);
    }

}
