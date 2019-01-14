/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebareadalllines;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*

 Este programa muestra la forma leer Todo el contenido de un archivo de texto
 en forma de líneas. Una vez leído el libro, vamos a efectuar algunos cálculos
 con respecto a las niñas leidas, y mostraremos el resultado en pantalla.

 El primer paso es descargar un libro de formato .txt en la página

 gutenberg.org


 */
/**
 *
 * @author coti
 */
public class PruebaReadAllLines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //
        // Forma de obtener la ruta del archivo si está en la carpeta
        // del proyecto. Funciona en todas las plataformas e idiomas
        //
        Path path = FileSystems.getDefault().getPath("./", "1984.txt");
        //
        // Este programa funciona porque 1984.txt está en la carpeta del proyecto
        //
        List<String> lineas = Files.readAllLines(path,
                StandardCharsets.UTF_8);
    // La lista lineas contiene el libro entero
        // Vamos a mostrar la longitud de cada línea
        for (int i = 0; i < lineas.size(); i++) {
            System.out.println("La línea "
                    + i
                    + " contiene "
                    + lineas.get(i).length()
                    + " caracteres");
        }
        System.out.println("El número de líneas leídas es " + lineas.size());
    }

}
