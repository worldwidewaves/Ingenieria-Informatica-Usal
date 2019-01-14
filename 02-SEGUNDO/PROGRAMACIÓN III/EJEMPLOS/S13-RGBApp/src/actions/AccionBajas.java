/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;
import java.util.Scanner;
/**
 *
 * @author coti
 */
public class AccionBajas extends Accion {

    public AccionBajas(){
        super();
    }

    @Override
    public void run() {
        this.getModelo().showContents();
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscriba el número de la persona que desea eliminar o pulse <INTRO> para continuar");
        s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println("\n***Bajas: acción cancelada por el usuario\n");
            return;
        }
        int n = Integer.parseInt(s);
        this.getModelo().remove(n);
    }
    
}
