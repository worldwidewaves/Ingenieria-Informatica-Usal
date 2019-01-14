//afdasfdasf¡'09
package vista;

import java.util.Scanner;
import controlador.Controlador;
import datos.Alumno;

public class Vista {

    private Controlador c = new Controlador();
    private final Scanner sc = new Scanner(System.in);

    public void mostrarListaSinDatos() {

        for (Alumno a : c.getListaSinDatos()) {
            System.out.printf("%s%n", a);
        }

    }

    public void mostrarListaConDatos() {

        for (Alumno a : c.getListaConDatos()) {
            System.out.printf("%s%n", a);
        }

    }

    public void pedirOpciones(String menu) {
        String opcion;
        do {
            System.out.printf("%s : ", menu);
            opcion = sc.nextLine();
            if (opcion.isEmpty()) {
                continue;
            }
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    mostrarListaSinDatos();
                    break;
                case "2":
                    mostrarListaConDatos();
                    break;
                case "q":
                    opcion = c.preguntarSiSalimos();
                    break;
                default:
                    System.out.printf("%n%nOpción incorrecta%n%n");
            }
        } while (!opcion.equals("salir"));
    }

    public void setControlador(Controlador c) {
        this.c = c;
    }
}
