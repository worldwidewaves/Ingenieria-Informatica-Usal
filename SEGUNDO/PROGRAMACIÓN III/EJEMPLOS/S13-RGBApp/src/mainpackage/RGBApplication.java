/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import actions.Accion;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author coti
 */
// Esto no debería requerir cambios
// V1.0, Nov 2012
// V2.0, Nov 2012

public class RGBApplication {

    private String menu;
    private HashMap<String, Accion> h;
    private Model m;

    public RGBApplication(String[] optionNames, Accion[] actionClasses) {
        h = new HashMap<>();
        m = new Model();
        menu = "";
        for (int i = 0; i < optionNames.length; i++) {
            menu += optionNames[i];
            menu += "\n";
            actionClasses[i].setModelo(m);
            h.put(optionNames[i].toUpperCase(), actionClasses[i]);
        }
        menu += "\nSalir\n";
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String possibleOption;
        while (true) {
            System.out.printf("Opciones:%n%n");
            System.out.printf("%s%n", menu);
            System.out.print("Escriba una opción: ");
            possibleOption = sc.nextLine().toUpperCase();
            if (possibleOption.equalsIgnoreCase("SALIR")) {
                break;
            }
            Accion a = h.get(possibleOption);
            if (a != null) {
                a.run();
            } else {
                System.out.println("\nOpción desconocida\n");
            }
        }

    }

    /**
     *
     */
    public void theEnd() {
        Scanner sc = new Scanner(System.in);
        String s;
        if (m.size() != 0) {
            System.out.println("\nDesea guardar el archivo? (s/n)");
            s = sc.nextLine();
            if (!s.toUpperCase().equalsIgnoreCase("S")) {
                System.out.println("\nNo se han guardado los datos\n");
                return;
            }
            if (m.getTheFile() == null) {
                System.out.println("\nEscriba un nombre para el archivo o pulse <INTRO> para salir");
                s = sc.nextLine();
                if (s.isEmpty()) {
                    System.out.println("\nNo se han guardado los datos\n");
                    return;
                }
            }
            if (m.saveTo(new File(s))) {
                System.out.println("\nDatos almacenados en " + s);
            } else {
                System.out.println("No fue posible guardar los datos en " + s);
            }

        }

    }
}
