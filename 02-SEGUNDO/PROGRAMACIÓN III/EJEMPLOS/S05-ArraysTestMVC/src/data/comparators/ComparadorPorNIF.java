/**
 * ****************************************************************************
 * Una vez escrito el encabezado del método, bastan tres clicks para que el IDE
 * añada todo lo necesario
 * ****************************************************************************
 */
package data.comparators;

import data.Factura;
import java.util.Comparator;

/**
 *
 * @author coti
 */
public class ComparadorPorNIF implements Comparator<Factura> {

    @Override
    public int compare(Factura fac1, Factura fac2) {
        String nif1 = fac1.getNIFdelReceptor();
        String nif2 = fac2.getNIFdelReceptor();
        return nif1.compareToIgnoreCase(nif2);
    }

}
