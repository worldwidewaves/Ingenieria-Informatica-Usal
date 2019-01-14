package numerosdetarjetadistintos;

/**
 *
 * @author bruegel
 */
import java.util.*;
import com.coti.textfiletools.AuxText;
import java.io.File;

public class NumerosDeTarjetaDistintos {

    public static void main(String[] args) {
        AuxText at = new AuxText(null);
        Set<String> noRep1 = new HashSet<>();
        Set<String> noRep2 = new LinkedHashSet<>();
        Set<String> noRep3 = new TreeSet<>();
        Iterator<String> it1, it2, it3;
        String temp;

        String[] listaOriginal = at.readList(new File("archivo_entrada.txt"));
        String[] numeroDeTarjeta = new String[listaOriginal.length];
        int j = 0;
        System.out.printf("+----------------------+----------------------+");
        System.out.printf("----------------------+----------------------+\n");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n"
                + "| %-20s | %-20s | %-20s | %-20s |\n",
                "Lista", "Contenido del", "Contenido del", "Contenido del",
                "original", "HashSet", "LinkedHashSet", "TreeSet");
        System.out.printf("+----------------------+----------------------+");
        System.out.printf("----------------------+----------------------+\n");
        /*
        +----------------------------------------+
        |Recorremos la lista original añadiendo  |
        |sus elementos a un ejemplar de cada tipo|
        |de implementación. Después mostraremos  |
        |el contenido de los tres conjuntos      |
        |en una tabla.                           |
        +----------------------------------------+
         */
        for (String s : listaOriginal) {
            if (s.length() != 0) {
                noRep1.add(temp = s.split("\\*")[0]);
                noRep2.add(temp);
                noRep3.add(temp);
                numeroDeTarjeta[j++] = temp;
            }
        }
        it1 = noRep1.iterator();
        it2 = noRep2.iterator();
        it3 = noRep3.iterator();
        for (int i = 0; i < listaOriginal.length; i++) {
            if (it1.hasNext() && it2.hasNext() && it3.hasNext()) {
                System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n",
                        numeroDeTarjeta[i],
                        it1.next(),
                        it2.next(),
                        it3.next());
            } else {
                System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n",
                        numeroDeTarjeta[i],
                        "",
                        "",
                        "");
            }
        }
        System.out.printf("+----------------------+----------------------+");
        System.out.printf("----------------------+----------------------+\n");
    }
}
