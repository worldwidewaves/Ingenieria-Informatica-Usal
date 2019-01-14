/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package otropaquete;

/**
 *
 * @author bruegel
 */
public class D4OtroPaquete extends D3OtroPaquete {
   
    @Override
    public void visibles() {
        System.out.printf("\nDesde una subclase de subclase en otro paquete, D4otroPaquete\n\n");
        System.out.println("No se hereda el atributo con visibilidad package,this.dePaquete");
        System.out.println(this.protegido);
        System.out.println(this.publico);
        System.out.println("No se hereda el atributo private");
    }

}
