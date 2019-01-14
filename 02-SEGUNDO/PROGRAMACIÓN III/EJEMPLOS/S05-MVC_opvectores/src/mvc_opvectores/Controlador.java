package mvc_opvectores;

import static com.coti.esdia.Esdia.*;
import java.awt.Toolkit;

/**
 *
 * @author bruegel
 */
public class Controlador {

    Modelo m;
    Vista v;

    public Controlador(Modelo _m, Vista _v) {
        this.m = _m;
        this.v = _v;
    }

    public void run(String[] args, String menu) throws Exception {
        String opcion;
        boolean salir = false;
        do {
            opcion = readString_ne(menu);
            switch (opcion.toLowerCase()) {
                case "módulo":
                case "modulo":
                    v.probarModulo();
                    break;
                case "escalar":
                case "producto escalar":
                    v.probarProductoEscalar();
                    break;
                case "vectorial":
                case "producto vectorial":
                    v.probarProductoVectorial();
                    break;
                case "mixto":
                case "producto mixto":
                    v.probarProductoMixto();
                    break;
                case "salir":
                case "q":
                    salir = true;
                    break;
                case "backdoor":
                    System.out.printf("Nombre: %s%n",
                            System.getProperty("user.name"));
                    System.out.printf("Directorio: %s%n",
                            System.getProperty("user.home"));
                    break;
                default:
                    System.out.printf("%nOpción incorrecta%n%n");
                    Toolkit.getDefaultToolkit().beep();
                    break;
            } // fin de switch
        } while (!salir);
        System.out.printf("%nTerminación normal del programa%n");
    } // fin de run
} // fin de Controlador
