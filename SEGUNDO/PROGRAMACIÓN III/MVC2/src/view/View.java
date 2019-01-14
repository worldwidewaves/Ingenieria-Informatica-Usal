/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Controler;
import java.util.Scanner;
import model.Model;

/**
 *
 * @author pgina37
 */

public class View {
 Scanner sc = new Scanner(System.in);
 Controler c= new Controler();
 
// Introducción, no hay MVC. Esto va a desaparecer
    

    public void runMenu(String menu) {
        /*
        Leer, Calcular, Mostrar, Salir
         */
        boolean salir = false;
        do {
            System.out.printf("%s:", menu);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    this.leerDatos();
                    break;
                case "2":
                    this.calcularResultados();
                    break;
                case "3":
                    this.mostrarResultados();
                    break;
                case "q":
                    salir = preguntarSiSalimos();
                    break;
                default:
                    System.out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        } while (!salir);
    }

    private boolean preguntarSiSalimos() {
        String opcion;
        do {
            System.out.printf("%nDesea realmente salir de la aplicación? [s/N]");
            opcion = sc.nextLine();
        } while (!"sSnN".contains(opcion));
        System.out.println();
        return (!opcion.isEmpty() &&"sS".contains(opcion));
    }

    private void leerDatos() {
        int num1, num2;
        System.out.printf("%nEscriba un número: ");
        num1 = sc.nextInt();
        System.out.printf("Escriba otro número: ");
        num2 = sc.nextInt();
        sc.nextLine();
        System.out.println();
        //
        // Esto no es mvc
        //
        c.setDatos(num1, num2);
    }

    private void calcularResultados() {
        System.out.printf("%n%nSe ha calculado el resultado%n%n");
        c.sumarValores();
        
    }

    private void mostrarResultados() {
        System.out.printf("%n%nLa suma de %d y %d es %d%n%n",
                c.getDato1(),
                c.getDato2(),
                c.getResu());
    }
    
}
