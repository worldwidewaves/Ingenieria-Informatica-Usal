/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
package listadepersonas;
import paqueteparaclasesdedatos.Persona;
/**
 *
 * @author coti
 */
public class ListaDePersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona[] lista = new Persona[3];
        lista[0] = new Persona("Juan Pérez", 22, 1.85f);
        lista[1] = new Persona("Juan Pérez", 33, 1.95f);
        lista[2] = new Persona("Juan Pérez", 44, 1.55f);
        for(Persona p : lista) {
            System.out.println(p);
        }
    }
    
}
