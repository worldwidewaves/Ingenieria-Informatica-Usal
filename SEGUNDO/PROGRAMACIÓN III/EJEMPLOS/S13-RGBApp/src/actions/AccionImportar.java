/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author coti
 */
public class AccionImportar extends Accion {

    public AccionImportar() {
        super();
    }

    @Override
    public void run() {
        File f;
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Importar: escriba  la ruta del archivo - ");
        s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println("\n***Importar: cancelado por el usuario");
            return;
        }
        f = new File(s);
        if (f.exists()) {
            this.getModelo().importFromDisk(f,"\\*");
        } else {
            System.out.println("\n***El archivo " + s + " no existe.\n");
        }
    }
    
}
