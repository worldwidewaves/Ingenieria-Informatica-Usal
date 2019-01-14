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
public class AccionExportar extends Accion {

    public AccionExportar() {
        super();
    }

    @Override
    public void run() {
        File f;
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Exportar: escriba  la ruta del archivo - ");
        s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println("\n***Exportar: cancelado por el usuario");
            return;
        }
        f = new File(s);
        if (this.getModelo().exportToDisk(f, "*")) {
            System.out.println("\nDatos exportados correctamente en " + s);
        } else {
            System.out.println("***No fue posible exportar los datos en el archivo" + s + "\n");
        }
    }
}
