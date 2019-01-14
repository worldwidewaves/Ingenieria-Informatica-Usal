/*
 * Departamento de Informática y Automática
 * Universidad de Salamanca - Programación III, Curso 2017-18
 * Copyright (C) J.R. García-Bermejo Giner
 */
package view;

import java.util.Scanner;
import controller.Controller;
import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.readString_ne;

/**
 *
 * @author coti
 */
public class View {

    private final Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);

    /**
     *
     * @param menu
     */
    public void runMenu(String menu) {
        String opcion;
        boolean salir = false;
        do {
            opcion = readString_ne(menu).toLowerCase();
            clear();
            switch (opcion) {
                case "1":  this.darValores();      break;
                case "2":  this.mostrarListado();  break;
                case "3":  this.save();            break;
                case "4":  this.load();            break;
                case "q":
                    salir = this.preguntarSiSalimos("Desea realmente"
                            + " salir de la aplicación? ");
                    break;
                default:
                    System.out.printf("%n%nOpción incorrecta%n%n");
            }
        } while (!salir);
    } // Fin de runMenu()

    public void darValores() {

        c.darValores();
        System.out.printf("%n%nSe han almacenado %d valores"
                + " en la lista.%n%n", c.getNumValores());

    } // End of darValores()

    public void mostrarListado() {
        String[] listado = c.obtenerListado();
        if (null == listado) {
            System.err.println("ERROR: no fue posible"
                    + " obtener el listado");
            return;
        }
        
        System.out.printf("%nListado de Facturas%n%n");
        for(String s : listado) {
            System.out.printf("%s%n", s);
        }
        System.out.printf("%n");
    } // End of mostrarListado()

    private boolean preguntarSiSalimos(String prompt) {
        String opcion;

        do {
            System.out.printf("%n%s [s/N]", prompt);
            opcion = sc.nextLine();

        } while (!"sSnN".contains(opcion));
        System.out.println();

        return (!opcion.isEmpty() && "sS".contains(opcion));
    }

    private void save() {
        c.save();
    }

    private void load() {
        c.load();
    }

} // Fin de View

