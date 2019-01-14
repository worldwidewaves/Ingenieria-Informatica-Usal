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
public class ComparadorPorNombres implements Comparator<MiniPersona> {
    
    @Override
    public int compare(MiniPersona m1, MiniPersona m2) {
        String nombre1 = m1.getNombre();
        String nombre2 = m2.getNombre();
        return nombre1.compareToIgnoreCase(nombre2);
    }
    
}
