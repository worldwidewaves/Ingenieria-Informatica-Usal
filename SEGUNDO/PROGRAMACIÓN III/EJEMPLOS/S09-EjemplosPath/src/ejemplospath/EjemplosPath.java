/*
*
 * -----
 * 
 * 
 * Este ejercicio ejercita algunos de los métodos de Path. Para comenzar,
 * se construyen ejemplares de Path a partir de:
 * 
 *    Una ruta en forma de String (p1, p4)
 *    Un argumento de la línea de órdenes (p2)
 *    Un URI (Uniform Resource Identifier) (p3). Los URIs pueden ser URNs o URLs.
 *    Una ruta construida a partir de una propiedad (p5)
 * 
 * Deliberadamente, se han utilizado como cadenas rutas correspondientes a
 * archivos o directorios que NO EXISTEN. Un Path es la representación de una
 * ruta, y esa ruta puede muy bien no existir. Por supuesto, es posible determinar
 * si el objeto descrito por la ruta (un archivo o directorio) existe o no,
 * como se verá.
 * 
 */
package ejemplospath;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Tests by coti
 */
public class EjemplosPath {

    public static void mostrarResultados(Path ruta) {
        System.out.format("toString     : %s%n", ruta.toString());
        System.out.format("getFileName  : %s%n", ruta.getFileName());
        System.out.format("getName(0)   : %s%n", ruta.getName(0));
        System.out.format("getNameCount : %d%n", ruta.getNameCount());
        if (ruta.getNameCount() > 2) {
            System.out.format("subpath(0,2) : %s%n", ruta.subpath(0, 2));
        } else {
            System.out.println("subpath(0,2) no tiene sentido");
        }
        System.out.format("getParent    : %s%n", ruta.getParent());
        System.out.format("getRoot      : %s%n", ruta.getRoot());
    }

    /**
     * @param args argumentos de la línea de órdenes
     */
    public static void main(String[] args) {

        Path p1 = Paths.get("/com/coti/textfiletools/NoExiste.java");
        Path p2 = Paths.get(args[0]);
        Path p3 = Paths.get(URI.create("file:///com/coti/textfiletools/NoExiste.java"));
        Path p4 = FileSystems.getDefault().getPath("/Users/coti/NoExiste");
        //
        // Este es el ejemplo crucial :)
        //
        Path p5 = Paths.get(System.getProperty("user.home"),
                "NoExiste",
                "NoNoNo.log");

        System.out.format("Ruta obtenida a partir de una cadena%n%n");
        mostrarResultados(p1);
        System.out.format("%n%nRuta obtenida a partir de la línea de órdenes%n%n");
        mostrarResultados(p2);
        System.out.format("%nRuta obtenida a partir de un URI%n%n");
        mostrarResultados(p3);
        System.out.format("%nRuta obtenida a partir de una cadena%n%n");
        mostrarResultados(p4);
        System.out.format("%nRuta obtenida a partir de una propiedad%n%n");
        mostrarResultados(p5);
    }
}
