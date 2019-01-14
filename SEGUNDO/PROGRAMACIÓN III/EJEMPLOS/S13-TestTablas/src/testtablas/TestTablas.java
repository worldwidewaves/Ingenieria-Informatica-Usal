/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testtablas;

import java.io.File;
import static testtablas.Tablas.*;

/**
 *
 * @author coti
 */
public class TestTablas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        // Creación de la tabla y preparación de rutas
        //
        double[][] m = createRandomTable(1000, 1000);
        File archivo_texto = new File("tabla_texto.txt");
        File archivo_binario = new File("archivo_binario.tablabin");
        File archivo_binario2 = new File("archivo_binario2.tablabin");
        //
        // Fase de escritura
        //
        System.out.print("Escribiendo tabla en formato delimitado");
        long principio = System.currentTimeMillis();
        exportTableToDisk(m, archivo_texto, "*");
        //exportTableToDisk2(m, archivo_texto, "*");
        long fin = System.currentTimeMillis();
        System.out.println("...terminado, t = " + (fin - principio));

        principio = System.currentTimeMillis();
        System.out.print("Escribiendo tabla en formato de objeto");
        writeTableToDiskAsObject(m, archivo_binario2);
        fin = System.currentTimeMillis();
        System.out.println("...terminado, t = " + (fin - principio));

        principio = System.currentTimeMillis();
        System.out.print("Escribiendo tabla en formato binario");
        writeTableToDisk(m, archivo_binario);
        fin = System.currentTimeMillis();
        System.out.println("...terminado, t = " + (fin - principio));
        //
        // Fase de lectura
        //
        System.out.print("Leyendo tabla en formato delimitado");
        principio = System.currentTimeMillis();
        double[][] p = importTableFromDisk(archivo_texto, "\\*");
        //double[][] p = importTableFromDisk2(archivo_texto, "\\*");
        fin = System.currentTimeMillis();
        System.out.println("...terminado, t = " + (fin - principio));

        System.out.print("Leyendo tabla en formato de objeto");
        principio = System.currentTimeMillis();
        p = readTableFromDiskAsObject(archivo_binario2);
        fin = System.currentTimeMillis();
        System.out.println("...terminado, t = " + (fin - principio));

        System.out.print("Leyendo tabla en formato binario");
        principio = System.currentTimeMillis();
        p = readTableFromDisk(archivo_binario);
        fin = System.currentTimeMillis();
        System.out.println("...terminado, t = " + (fin - principio));
    }
}
