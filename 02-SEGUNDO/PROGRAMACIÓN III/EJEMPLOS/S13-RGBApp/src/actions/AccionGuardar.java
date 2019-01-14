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
public class AccionGuardar extends Accion {

    public AccionGuardar() {
        super();
    }

    @Override
    public void run() {
        File f;
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Guardar: escriba  la ruta del archivo - ");
        s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println("\n***Guardar: cancelado por el usuario");
            return;
        }
        f = new File(s);
        if (f.exists()) {
            this.getModelo().saveTo(f);
        } else {
            System.out.println("\n***El archivo " + s + " no se pudo guardar.");
        }
    }
}
