/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package ejemploherencia;

import otropaquete.OtraClaseDerivada;

/**
 *
 * @author bruegel
 */
public class EjemploHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClaseDerivada cd = new ClaseDerivada();
        System.out.println("cd.atributoPublico   = " + cd.atributoPublico);
        System.out.println("cd.atributoDePaquete = " + cd.atributoDePaquete);
        System.out.println("cd.atributoProtegido = " + cd.atributoProtegido);
        System.out.println("No es visible el atributo private");
        //        System.out.println(cd.atributoPrivado);

        System.out.println();
        OtraClaseDerivada ocd = new OtraClaseDerivada();
        System.out.println("ocd.atributoProtegido = " + ocd.atributoProtegido);
        System.out.println("ocd.atributoPublico = " + ocd.atributoPublico);
        System.out.println("No es visible el atributo private");
        System.out.println("No es visible el atributo con visibilidad de paquete");
        //        System.out.println(ocd.atributoPrivate);
        //        System.out.println(ocd.atributoDePaquete);
    }

}
