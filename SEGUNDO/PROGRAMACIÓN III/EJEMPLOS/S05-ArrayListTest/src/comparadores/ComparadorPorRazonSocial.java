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
public class ComparadorPorRazonSocial implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        String rs1 = fac1.getDomicilio_social();
        String rs2 = fac2.getDomicilio_social();
        return rs1.compareToIgnoreCase(rs1);
    }

}
