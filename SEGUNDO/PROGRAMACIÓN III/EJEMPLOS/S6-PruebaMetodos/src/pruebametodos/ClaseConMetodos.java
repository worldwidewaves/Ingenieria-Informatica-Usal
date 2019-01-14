/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package pruebametodos;

/**
 *
 * @author bruegel
 */
public class ClaseConMetodos {

    void metodoMudo() {
        System.out.println("Yo no digo nada");
    }

    void metodoSinResultadosConArgumentos(float num) {
        System.out.printf("El número es %5.3f\n",
                num);
    }

    int metodoConResultadoSinArgumentos() {
        return 42;
    }

    String metodoConResultadosConArgumentos(double num) {
        String resultado = String.format("El cuadrado de %5.3f es %10.6f\n",
                num,
                Math.pow(num, 2.0));
        return resultado;
    }

}
