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
public class AccionAbrir extends Accion {

    public AccionAbrir() {
        super();
    }

    @Override
    public void run() {
        File f;
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Abrir: escriba  la ruta del archivo - ");
        s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println("\n***Abrir: cancelado por el usuario.");
        }
        f = new File(s);
        if (f.exists()) {
            this.getModelo().loadFrom(f);
        } else {
            System.out.println("***El archivo " + s + " no existe. ");
        }
    }
}
