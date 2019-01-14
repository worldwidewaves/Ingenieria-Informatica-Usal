/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlistas;

import java.io.File;
import static testlistas.Listas.*;
/**
 *
 * @author coti
 */
public class TestListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] listaDePrueba = createRandomList(10);
        File rutaDelArchivo = new File("datos.txt");
        writeListToDisk(listaDePrueba, rutaDelArchivo);
        System.out.println("Esta es la lista creada:\n");
        writeListToTerminal(listaDePrueba);
        listaDePrueba = null;
        listaDePrueba = readListFromDisk(rutaDelArchivo);
        System.out.println("\nEsta es la lista leída:\n");
        writeListToTerminal(listaDePrueba);
    }
}
