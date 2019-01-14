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
public class PruebaMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           ClaseConMetodos ccm = new ClaseConMetodos();
           
           ccm.metodoMudo();
           
           ccm.metodoSinResultadosConArgumentos(33.3f);
           
           int n = ccm.metodoConResultadoSinArgumentos();
           System.out.printf("ccm.metodoConResultadosSinArgumentos() -> %d\n",n);
           
           String s = ccm.metodoConResultadosConArgumentos(Math.PI);
           System.out.printf("ccm.metodoConResultadosConArgumentos(Math.PI) -> %s",
                   s);
    }
    
}
