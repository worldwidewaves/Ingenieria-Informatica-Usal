import static com.coti.tools.DiaUtil.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusquedaBinFrente {

    private static String[] listaDesordenada;
    private static String[] listaOrdenada;

    public static void main(String[] args) {
        cargarListas();

        startTimer();
        busquedaSecuencial();
        stopTimerAndPrintElapsedTimeMillis();

        startTimer();
        busquedaBinaria();
        stopTimerAndPrintElapsedTimeMillis();
    }

    private static void busquedaSecuencial() {
        String apellido_buscado = "Carbajal";
        for (String s : listaDesordenada) {
            if (s.equals(apellido_buscado)) {
                System.out.printf("%n%nSecuencial - He encontrado el apellido%n%n");
                break;
            }
        }
    }

    private static void busquedaBinaria() {
        String apellido_buscado = "Carbajal";// En el punto medio de la lista
        if (Arrays.binarySearch(listaOrdenada, apellido_buscado) >= 0) {
            System.out.printf("%n%nBinaria - He encontrado el apellido%n%n");
        }
    }

    private static void cargarListas() {
        File f = new File("./apellidos.txt");
        List<String> temp;
        try {
            temp = Files.readAllLines(f.toPath(), Charset.forName("UTF8"));
        } catch (IOException ex) {
            Logger.getLogger(BusquedaBinFrente.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        listaOrdenada = temp.toArray(new String[temp.size()]);
        Collections.shuffle(temp);
        listaDesordenada = temp.toArray(new String[temp.size()]);
    }

}
