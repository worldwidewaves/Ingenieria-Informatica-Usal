/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import datos.MiniPersona;
import java.util.Comparator;

/**
 *
 * @author bruegel
 */
public class ComparadorPorPeso implements Comparator<MiniPersona> {

   
    @Override
    public int compare(MiniPersona mp1, MiniPersona mp2) {
        Float peso1 = mp1.getPeso(); // esto es, = new Integer(mp1.getEdad())
        Float peso2 = mp2.getPeso(); // esto es, = new Integer(mp2.getEdad())
        return peso1.compareTo(peso2);
    }
    
}
