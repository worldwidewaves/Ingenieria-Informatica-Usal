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
public class PruebaVarargs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClaseVarargs cva = new ClaseVarargs();

        cva.metodoConVararg(33, 44.5f, "Mary", "had", "a", "little", "sheep");

        System.out.printf("\nSegunda llamada al método\n\n");
      
        cva.metodoConVararg(44, 33.5f, "Hallo, Welt!");
    }
    
}
