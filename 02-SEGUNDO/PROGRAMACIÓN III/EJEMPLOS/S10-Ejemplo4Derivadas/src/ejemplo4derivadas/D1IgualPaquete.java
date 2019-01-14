/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package ejemplo4derivadas;

/**
 *
 * @author bruegel
 */
public class D1IgualPaquete extends ClaseBase {
    
    void visibles() {
        System.out.printf("\nDesde una subclase en el mismo paquete, D1IgualPaquete\n\n");
        System.out.println(this.dePaquete);
        System.out.println(this.protegido);
        System.out.println(this.publico);
        System.out.println("No se hereda el atributo private");
    }
    
}
