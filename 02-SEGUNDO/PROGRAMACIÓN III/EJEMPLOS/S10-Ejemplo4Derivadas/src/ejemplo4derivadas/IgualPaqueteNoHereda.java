/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package ejemplo4derivadas;

import otropaquete.D4OtroPaquete;




/**
 *
 * @author bruegel
 */
public class IgualPaqueteNoHereda {
    
    ClaseBase cb = new ClaseBase();
    D4IgualPaquete d4igual = new D4IgualPaquete();
    D4OtroPaquete d4otro = new D4OtroPaquete();
    
    public void visibles() {
        
        System.out.printf("\nDesde otra clase del mismo paquete, IgualPaqueteNoHereda\n\n");
        
        System.out.println("\n\nClaseBase\n\n");
        System.out.println("base:" + cb.dePaquete);
        System.out.println("base:" + cb.protegido);
        System.out.println("base:" + cb.publico);
        
        System.out.println("\n\nClase D4IgualPaquete\n\n");
        System.out.println("D4IgualPaquete:" + d4igual.dePaquete);
        System.out.println("D4IgualPaquete:" + d4igual.protegido);
        System.out.println("D4IgualPaquete:" + d4igual.publico);        
        
        System.out.println("\n\nClase D4OtroPaquete\n\n");
        // En cuanto salimos del paquete, los atributos con visibilidad de paquete
        // no son visibles.
        //System.out.println("D4OtroPaquete:" + d4otro.dePaquete);
        System.out.println("D4OtroPaquete:" + d4otro.protegido);
        System.out.println("D4OtroPaquete:" + d4igual.publico);        
        
    }
}
