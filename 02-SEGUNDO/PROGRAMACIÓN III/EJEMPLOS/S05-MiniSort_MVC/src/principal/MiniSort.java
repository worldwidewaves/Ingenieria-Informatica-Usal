package principal;

import vistas.Vista;
import datos.Modelo;
import logica.Controlador;

/**
 *
 * @author bruegel
 */
public class MiniSort {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Modelo m = new Modelo();
        Vista v = new Vista(m);
        Controlador c = new Controlador(m, v);
        c.run(args, "Opciones:"
                + " Lista aleatoria, "
                + " Listado,"
                + " Ordenar por nombre,"
                + " Ordenar por edad,"
                + " Salir"
                + "\n\nEscriba una opción : ");
    }

}
