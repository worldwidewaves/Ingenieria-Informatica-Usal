/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package termicon;

import java.io.Console;

/**
 *
 * @author bruegel
 */
public class TermiCon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console c = System.console();
        c.printf("Escriba una frase: ");
        String frase = c.readLine();
        c.printf("La frase %s contiene %d caracteres%n.", frase, frase.length());
    }
    
}
