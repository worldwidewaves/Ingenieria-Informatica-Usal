/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package otropaquete;
// Imprescindible impoortar ClaseBase por estar en ejemplo4Derivada
import ejemplo4derivadas.ClaseBase;

/**
 *
 * @author bruegel
 */
public class D1OtroPaquete extends ClaseBase {

    /**
     *
     */
    public void visibles() {
        System.out.printf("\nDesde una subclase en otro paquete, D1otroPaquete\n\n");
        System.out.println("No se hereda el atributo con visibilidad package,this.dePaquete");
        System.out.println(this.protegido);
        System.out.println(this.publico);
        System.out.println("No se hereda el atributo private");
    }

}
