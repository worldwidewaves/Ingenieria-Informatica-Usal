/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de_path_a_ruta;

import java.net.URI;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Tests by coti
 */
public class De_Path_a_Ruta {

    /**
     * @param args argumentos de la línea de órdenes
     */
    public static void main(String[] args) {
        // Este proyecto no hace nada, pero lo hace todo muy bien
        
        Path ruta = Paths.get("../EjemplosPath/src/ejemplospath/EjemplosPath2.java");
        URI uri = null;
        Path ruta_absoluta = null;
        Path ruta_verdadera = null;
        try {
           uri = ruta.toUri();
           ruta_absoluta = ruta.toAbsolutePath();
           ruta_verdadera = null;
           ruta_verdadera = ruta.toRealPath(LinkOption.NOFOLLOW_LINKS);
        } catch(Exception e) {
            System.out.println("---------------------");
            System.err.println("El archivo no existe.");
            System.out.println("---------------------");
            System.err.println(e);
        }
        System.out.format("Ruta inicial    : %s%n%n", ruta.toString());
        System.out.format("Ruta absoluta   : %s%n%n", ruta_absoluta.toString());
        System.out.format("URI             : %s%n%n", uri.toString());
        System.out.format("Ruta verdadera  : %s%n%n", ruta_verdadera.toString());
        
    }
}
