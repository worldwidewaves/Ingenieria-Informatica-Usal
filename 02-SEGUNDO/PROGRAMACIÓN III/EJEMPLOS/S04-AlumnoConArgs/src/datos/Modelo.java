//afdasfdasf¡'09
package datos;

import java.util.Random;

public class Modelo {

    private final Alumno[] listaSinDatos;
    private final Alumno[] listaConDatos;

    public Modelo() {
        listaSinDatos = new Alumno[10];
        listaConDatos = new Alumno[10];

        this.crearAlumnosSinDatos();
        this.crearAlumnosConDatos();
    }

    public final void crearAlumnosSinDatos() {

        for (int i = 0; i < listaSinDatos.length; i++) {
            listaSinDatos[i] = new Alumno();
        }

    }

    public final void crearAlumnosConDatos() {

        boolean[] temp = new boolean[15];
        Random r = new Random();

        for (int i = 0; i < listaConDatos.length; i++) {

            for (int j = 0; j < temp.length; j++) {
                temp[j] = r.nextBoolean();
            }
            String[] nombres = {"Ana", "Juana", "María"};
            String nombre = nombres[r.nextInt(3)];
            String[] apellidos = {"García", "López", "Pérez", "Gómez"};
            String ape_1 = apellidos[r.nextInt(4)];
            String ape_2 = apellidos[r.nextInt(4)];
            long tele = 9230000000L + r.nextInt(1000000);
            listaConDatos[i] = new Alumno(nombre, ape_1, ape_2, tele, temp);

        }
    }

    public Alumno[] getListaSinDatos() {
        return listaSinDatos;
    }

    public Alumno[] getListaConDatos() {
        return listaConDatos;
    }

}
