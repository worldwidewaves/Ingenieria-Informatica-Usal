/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2018-19
 * Copyright (C) J.R. García-Bermejo Giner
 */
package pruebavarargs;

/**
 *
 * @author bruegel
 */
public class ClaseVarargs {

    void metodoConVararg(int n, float m, String ... argumentos) {
        System.out.printf("n = %d\n", n);
        System.out.printf("m = %5.2f\n", m);
        System.out.printf("\nLos argumentos finales son\n\n");
        for(String s : argumentos) {
            System.out.println(s);
        }
    }
  
}
