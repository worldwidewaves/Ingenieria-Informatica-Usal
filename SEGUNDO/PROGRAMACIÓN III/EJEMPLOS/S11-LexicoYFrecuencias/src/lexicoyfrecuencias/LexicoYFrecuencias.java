/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Run->Set Project Configuration->Customize...
 * 
 * en Arguments se pone el nombre del archivo
 * 
 * 
 */
package lexicoyfrecuencias;

/**
 *
 * @author Tests by coti
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LexicoYFrecuencias {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> m = new TreeMap<>();
        String[] listaDeFragmentos;
        String[] faw;
        int numeroDeFragmentos = 0;
        int numeroDePalabrasDistintas = 0;
        Set<String> keySet;
        char[] encabezado = new char[50];
        Integer frecuencia;
        //
        // Si el usuario no aporta el nombre del archivo a través de la
        // línea de órdenes, indicamos que debe hacerlo y salimos.
        //
        if (args.length == 0) {
            System.out.print("\nUso: java -jar laf.jar archivo_entrada\n\n");
            return;
        }
        //
        // Calculamos la ruta
        //
        Path p = Paths.get("datosentrada.txt");
        //
        // Si no existe el archivo, lo indicamos y salimos
        //
        if (!p.toFile().exists()) {
            System.out.printf("%n%nError: no existe %s%n%n", p.toString());
            return;
        }
        String delimPalabra = "[\\s\\r\\n,.;?¿¡!\"':\\«\\»\\-\\(\\)]";
        String texto = new String(Files.readAllBytes(p));
        listaDeFragmentos = texto.split(delimPalabra);
        for (String temp : listaDeFragmentos) {
            if (temp.length() != 0) {
                frecuencia = m.get(temp);
                m.put(temp, (frecuencia == null) ? 1 : frecuencia + 1);
            }
        }
        numeroDePalabrasDistintas = m.size();
        System.out.println("\nLexico con frecuencias (alfabético)\n\n");
        System.out.println("Palabras distintas: " + m.size());
        Arrays.fill(encabezado, 0, 50, '\0');
        Arrays.fill(encabezado, 0, 46, '-');
        encabezado[0] = '+';
        encabezado[23] = '+';
        encabezado[46] = '+';
        System.out.println(encabezado);
        System.out.printf("| %-20s | %-20s |\n", "Palabras", "Frecuencias");
        System.out.println(encabezado);
        StringBuilder sb = new StringBuilder();
        m.keySet().forEach((String s) -> {
            sb.append(String.format("| %-20s | %20d |\n", s, m.get(s)));
        });
        sb.append(encabezado).append("\n");
        System.out.println(sb.toString());
        /*
          Ahora se genera un léxico ordenado por frecuencias
         */
        System.out.println("\nLexico con frecuencias (por frecuencias)\n\n");
        System.out.println(encabezado);
        System.out.printf("| %-20s | %-20s |\n", "Frecuencias", "Palabras");
        encabezado[23] = '+';
        System.out.println(encabezado);
        TreeSet<Integer> frecOrdenadas = new TreeSet<>(m.values());
        sb.setLength(0);
        frecOrdenadas.forEach((Integer frec) -> {
            m.keySet().stream().filter((s) -> (m.get(s).equals(frec))).forEachOrdered((String s) -> {
                sb.append(String.format("| %20d | %-20s |\n", frec, s));
            });
        });
        encabezado[23] = '+';
        sb.append(encabezado).append("\n");
        System.out.println(sb.toString());
    }
}
/*
 This can possibly be done with Collections.frequency(),
 by passing the list to an ArrayList.
 */
