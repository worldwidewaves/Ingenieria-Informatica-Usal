package numerosdetarjetadistintos;

/*
La estructura HashSet no mantiene el orden de adición
La estructura LinkedHashSet mantiene el orden de adición
La estructura TreeSet ordena de menor a mayor los elementos añadidos
 */
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NumerosDeTarjetaDistintos {

    public static void main(String[] args) throws IOException {
        //
        // Se crea un ejemplar de cada tipo de implementación de Set<T>
        //
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        //
        // Se prepara una lista para almacenar todos los números de tarjeta,
        // incluyendo los repetidos
        //
        List<String> todosLosNumeros = new ArrayList<>();
        //
        // Se obtiene la ruta del archivo, suponiendo que está en la
        // carpeta del proyecto
        //
        Path rutaDelArchivo = Paths.get("archivo_entrada.txt");
        //
        // Si no existe,salimos del programa
        //
        if (!rutaDelArchivo.toFile().exists()) {
            System.out.printf("%n%nNo se ha encontrado archivo_entrada.txt... saliendo%n%n");
            return;
        }
        //
        // Si existe el archivo, se leen todas las líneas presentes
        //
        List<String> lineasDelArchivo = Files.readAllLines(rutaDelArchivo);
        //
        // Se muestra el encabezado
        //
        /*
         *+----------------------+----------------------+----------------------+----------------------+
         *| Lista                | Contenido del        | Contenido del        | Contenido del        |
         *| original             | HashSet              | LinkedHashSet        | TreeSet              |
         *+----------------------+----------------------+----------------------+----------------------+
         *
         */
        String separador = "+----------------------"
                + "+----------------------+"
                + "----------------------"
                + "+----------------------+\n";
        System.out.printf(separador);
        String unaFila = "| %-20s | %-20s | %-20s | %-20s |\n";
        System.out.printf(unaFila + unaFila,
                "Lista", "Contenido del", "Contenido del", "Contenido del",
                "original", "HashSet", "LinkedHashSet", "TreeSet");
        System.out.printf(separador);
        /*
        +----------------------------------------+
        |Recorremos la lista original añadiendo  |
        |sus elementos a un ejemplar de cada tipo|
        |de implementación. Después mostraremos  |
        |el contenido de los tres conjuntos      |
        |en una tabla.                           |
        +----------------------------------------+
         */
        lineasDelArchivo.forEach((s) -> {
            //
            // Se descartan las líneas vacías. Si no hay seguridad,
            // convendría comprobar que el número de separadores es 1,
            // y que el primer campo es un número de 16 dígitos
            //
            // Idea : crear un método auxiliar func validCardNumberIn(line : String) -> Boolean
            //
            if (!s.equals("")) {

                String[] fragmentos = s.split("\\*");
                String temp = fragmentos[0];

                hashSet.add(temp);
                linkedHashSet.add(temp);
                treeSet.add(temp);
                todosLosNumeros.add(temp);
            }
        });
        //
        // Se crean tres iteradores, uno para cada conjunto. Ojo,
        // hay que crearlos cuando el conjunto ya está lleno!
        //
        Iterator<String> iteratorHash = hashSet.iterator();
        Iterator<String> iteratorLinkedHash = linkedHashSet.iterator();
        Iterator<String> iteratorTree = treeSet.iterator();
        //
        // Finalmente se muestra la tabla con sus cuatro columnas.
        // La primera columna son todos los números de tarjeta,
        // con repeticiones. Las otras tres columnas son los tres conjuntos
        // a los que se han añadido los números de tarjeta
        //
        todosLosNumeros.forEach((String numTarjeta) -> {
            //
            // Se averigua si hay que mostrar todas las columnas
            // o solo la primera
            //
            boolean cuatroColumnas = iteratorHash.hasNext()
                    && iteratorLinkedHash.hasNext()
                    && iteratorTree.hasNext();
            //
            // Si son las 4, se muestran las 4
            //
            if (cuatroColumnas) {
                System.out.printf(unaFila,
                        numTarjeta,
                        iteratorHash.next(),
                        iteratorLinkedHash.next(),
                        iteratorTree.next());
            } else {
                //
                // Si ya se han mostrado todos los conjuntos, se muestra
                // solo la primera (todos los números de tarjeta, con repeticiones).
                //
                System.out.printf(unaFila,
                        numTarjeta,
                        "",
                        "",
                        "");
            }
        });// Fin de forEach()
        System.out.printf(separador);
    }
}
