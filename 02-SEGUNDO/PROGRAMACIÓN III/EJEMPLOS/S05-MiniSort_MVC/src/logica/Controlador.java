package logica;

import datos.Modelo;
import vistas.Vista;
import static com.coti.esdia.Esdia.*;
import java.awt.Toolkit;

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
                case "lista aleatoria":
                case "aleatoria":
                    v.verListaAleatoria();             break;
                case "listado":v.mostrarListado();     break;
                case "ordenar por nombre":
                case "nombre": v.ordenarPorNombres();  break;
                case "ordenar por edad":
                case "edad":v.ordenarPorEdades();      break;
                case "peso":v.ordenarPorPesos();       break;
                case "salir":
                case "q":salir = true;                 break;
                  default:
                    System.out.printf("%nOpción incorrecta%n%n");
                    Toolkit.getDefaultToolkit().beep();
                    break;
            } // fin de switch
        } while (!salir);
        System.out.printf("%nTerminación normal del programa%n");
    } // fin de run
} // fin de Controlador
