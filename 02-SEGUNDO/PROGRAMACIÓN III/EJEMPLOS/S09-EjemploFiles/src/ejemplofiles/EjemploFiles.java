/*
 * Este programa utiliza métodos de la clase Files para abrir un archivo de texto,
 * leer su contenido por líneas, y volver a escribir el contenido del archivo
 * en otro archivo distinto. El uso de estos métodos supone una ganancia de 
 * prestaciones.
 * 
 */
package ejemplofiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tests by coti
 */
public class EjemploFiles {

    /**
     * @param args argumentos de la línea de órdenes
     */
    public static void main(String[] args) {
        Path ruta_entrada = Paths.get("entrada.txt");
        Path ruta_salida = Paths.get("salida.txt");
        System.out.println("El Charset por defecto es " + 
                Charset.defaultCharset().toString());
        System.out.println("Se va a emplear el Charset MacRoman");
        List<String> lineas = new ArrayList<>(); // ;)
        long principio, tiempo;
        if (!Files.exists(ruta_entrada, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("El archivo "
                    + ruta_entrada.getFileName()
                    + " no existe");
            return;
        }

        try {
            principio = System.currentTimeMillis();
            lineas = Files.readAllLines(ruta_entrada,
                    Charset.forName("MacRoman"));
        } catch (IOException e) {
            System.out.println("No fue posible leer el archivo");
            System.out.println(e);
            return;
        }
        tiempo = System.currentTimeMillis() - principio;
        System.out.format("Se han leído %s líneas"
                + " en %d ms%n",
                lineas.size(), tiempo);

        try {
            Files.deleteIfExists(ruta_salida);
        } catch (Exception e) {
            System.out.println("No fue posible borrar el archivo de salida");
            System.out.println(e);
            return;
        }

        principio = System.currentTimeMillis();
        try {
            Files.write(ruta_salida, lineas, Charset.forName("MacRoman"), StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.out.println("No fue posible escribir el archivo de salida");
            System.out.println(e);
            return;
        }
        tiempo = System.currentTimeMillis() - principio;
        System.out.format("Se han escrito %s líneas en %d ms%n",
                lineas.size(), tiempo);
    }
}
/*
 *

El Charset por defecto es UTF-8
Se va a emplear el Charset MacRoman
Se han leído 36851 líneas en 86 ms
Se han escrito 36851 líneas en 88 ms

 * 
 */