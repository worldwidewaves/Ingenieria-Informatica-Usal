/*
 * Atención
 * Este proyecto hace uso de Esdia.java y OpVect.java,
 * cuyos métodos se importan estáticamente.
 *
 */
package mvc_opvectores;

/**
 *
 * @author bruegel
 */
public class MVC_opvectores {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Modelo m = new Modelo();
        Vista v = new Vista(m);
        Controlador c = new Controlador(m, v);
        c.run(args, "Vectores: "
                + " Módulo, "
                + " P. escalar, "
                + " P. vectorial, "
                + " P. Mixto, "
                + " Salir"
                + "\n\nEscriba una opción : ");
    } // fin de main()
} // fin de MVC_opvectores
