/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_opvectores;

import static com.coti.tools.OpVect.*;

/**
 *
 * @author bruegel
 */
public class Vista {

    Modelo m;

    Vista(Modelo _m) {
        this.m = _m;
    } // fin del constructor

    void probarModulo() throws Exception {
        System.out.printf("%nMódulo de un vector%n%n");
        m.v1 = leerVector(3);
        System.out.printf("%nEl módulo del vector %s es %6.2f%n%n",
                vToS(m.v1),
                modulo(m.v1));
    } // fin de probarModulo

    void probarProductoEscalar() throws Exception {
        System.out.printf("%nProducto escalar de dos vectores%n%n");
        System.out.printf("Escriba el primer vector:%n");
        m.v1 = leerVector(3);
        System.out.printf("%nEscriba el segundo vector:%n");
        m.v2 = leerVector(3);
        System.out.printf("%n%s · %s = %6.2f%n%n",
                vToS(m.v1),
                vToS(m.v2),
                proEscalar(m.v1, m.v2));
    } // fin de probarProductoEscalar

    void probarProductoVectorial() throws Exception {
        System.out.printf("%nProducto vectorial de dos vectores%n%n");
        System.out.printf("Escriba el primer vector:%n");
        m.v1 = leerVector(3);
        System.out.printf("%nEscriba el segundo vector:%n");
        m.v2 = leerVector(3);
        m.v3 = proVectorial(m.v1, m.v2);
        System.out.printf("%n%s X %s = %s%n%n",
                vToS(m.v1),
                vToS(m.v2),
                vToS(m.v3));
    }// fin de proVectorial

    void probarProductoMixto() throws Exception {
        System.out.printf("%nProducto mixto de tres vectores%n%n");
        System.out.printf("Escriba el primer vector:%n");
        m.v1 = leerVector(3);
        System.out.printf("%nEscriba el segundo vector:%n");
        m.v2 = leerVector(3);
        System.out.printf("%nEscriba el tercer vector:%n");
        m.v3 = leerVector(3);
        double resultado = proMixto(m.v1, m.v2, m.v3);
        System.out.printf("%n%s · (%s X %s) = %6.2f%n%n",
                vToS(m.v1),
                vToS(m.v2),
                vToS(m.v3),
                resultado);
    } // fin de probarProductoMixto
} // fin de Vista
