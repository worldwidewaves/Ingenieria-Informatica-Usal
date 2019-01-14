/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturadebytesconmemoriaintermedia;

/**
 *
 * @author Tests by coti
 */
import java.io.*;

public class LecturaDeBytesConMemoriaIntermedia {

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        /*
         * Primero se intenta abrir los archivos, para copiar el contenido
         * byte por biyte
         */
        try {
            in = new FileInputStream("donau_ufer.jpg");
            if (null == in)
                System.out.println("No se ha creado in");
            
            bin = new BufferedInputStream(in);
            if(null == bin)
                System.out.println("No se ha creado bin");
            
            out = new FileOutputStream("copia_de_donau_ufer.jpg");
            if (null == out)
                System.out.println("No se ha creado out");
            
            bout = new BufferedOutputStream(out);
            if (null == bout)
                System.out.println("No se ha creado bout");
            
            int c;

            while ((c = bin.read()) != -1) {
                bout.write(c);
            }

        } catch (Exception e) {
            System.out.println("No fue posible abrir alguno de los archivos");
            System.out.println(e);
        }
        System.out.println("La lectura y escritura ha concluido con éxito.");
        /*
         * Después se intenta cerrar los archivos
         */
        try {
            if (bin != null) {
                bin.close();
            }
            if (bout != null) {
                bout.close();
            }
        } catch (Exception e) {
            System.out.println("No fue posible cerrar alguno de los archivos");
        }
        System.out.println("El cierre de archivos ha concluido con éxito");
    }
}
