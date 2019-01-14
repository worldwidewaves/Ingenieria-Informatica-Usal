/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Comparator;
import datos.MiniPersona;

/**
 *
 * @author bruegel
 */
public class ComparadorPorEdades implements Comparator<MiniPersona> {

    public ComparadorPorEdades() {
    }

    @Override
    public int compare(MiniPersona mp1, MiniPersona mp2) {
        Integer edad1 = mp1.getEdad(); // esto es, = new Integer(mp1.getEdad())
        Integer edad2 = mp2.getEdad(); // esto es, = new Integer(mp2.getEdad())
        return edad1.compareTo(edad2);
    }
    
}
