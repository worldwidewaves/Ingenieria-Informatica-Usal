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
public class ComparadorPorFecha implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        String fecha1 = fac1.getFecha();
        String fecha2 = fac2.getFecha();
        return fecha1.compareToIgnoreCase(fecha2);
    }

}
