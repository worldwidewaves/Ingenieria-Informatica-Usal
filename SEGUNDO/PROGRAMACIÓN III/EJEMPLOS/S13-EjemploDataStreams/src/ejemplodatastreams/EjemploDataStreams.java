/*
Version History

Modified 2013, catch clauses changed

*/
package ejemplodatastreams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Tests by coti
 */
public class EjemploDataStreams {

    /**
     * @param args argumentos de la línea de órdenes
     */
    public static void main(String[] args) {
        try {
            DataOutputStream out;
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("archivo.bin")));
            out.writeUTF("áéíóú");
            out.close();
        } // fin de main
        catch (FileNotFoundException ex) {
            System.err.println("No fue posible crear el archivo");
        } catch (IOException ex) {
            System.err.println("No fue posible escribir en el archivo");
        }
    } // fin de main
} // fin de EjemploDataStreams
