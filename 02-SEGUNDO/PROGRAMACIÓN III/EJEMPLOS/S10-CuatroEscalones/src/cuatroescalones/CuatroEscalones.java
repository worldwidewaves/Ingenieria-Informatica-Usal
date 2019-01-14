/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package cuatroescalones;

import otropaquete.DerivadaTercera;

/**
 *
 * @author bruegel
 */
public class CuatroEscalones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DerivadaTercera dt = new DerivadaTercera();
        System.out.printf("%nDerivadaTercera hereda "
                + "todos los atributos por ser públicos%n%n");
        System.out.println(dt.abase);
        System.out.println(dt.aDerivadaPrimera);
        System.out.println(dt.aDerivadaSegunda);
        System.out.println(dt.aDerivadaTercera);
    }

}
