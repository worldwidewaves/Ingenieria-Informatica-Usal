/*
 * 
 * El método leerDeTeclado() no utiliza Esdia.
 * El método leerDeTeclado2() utiliza Esdia.
 * 
 */
package crearclasesficha;

import java.util.Scanner;
import static com.coti.esdia.Esdia.*;

/**
 *
 * @author coti
 */
public class Ficha {

    private String nombre;
    private String apellidos;
    private String curso;
    private String DNI;
    private String grupoPracticas;
    private int numNotas;
    private float[] calificaciones;
    private String comentarios;

    public Ficha() {
        nombre = "Nombre";
        apellidos = "Apellidos";
        curso = "2011";
        DNI = "01234567X";
        grupoPracticas = "X7";
        numNotas = 5;
        calificaciones = new float[numNotas];// Ojo, imprescindible asignar memoria
        for (int i = 0; i < numNotas; i++) {
            calificaciones[i] = i;
        }
        comentarios = "Comentarios";
    }

    public Ficha(Ficha orig) {
        nombre = orig.nombre;
        apellidos = orig.apellidos;
        curso = orig.curso;
        DNI = orig.DNI;
        grupoPracticas = orig.grupoPracticas;
        numNotas = orig.numNotas;
        calificaciones = orig.calificaciones.clone();// OJO
        comentarios = orig.comentarios;
    }

    public Ficha(String nom,
            String ape,
            String cur,
            String ID,
            String gp,
            float[] cal,
            int num,
            String com) {
        nombre = nom;
        apellidos = ape;
        curso = cur;
        DNI = ID;
        grupoPracticas = gp;
        numNotas = num;
        calificaciones = cal.clone();
        comentarios = com;
    }

    void leerDeTeclado() {
        Scanner sc = new Scanner(System.in);
        String temp;
        boolean numeroBien = false;
        do {
            System.out.printf("Por favor, escriba su nombre: ");
            nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                System.out.println("\nPerdón, este campo no se puede dejar en blanco\n");
            }
        } while (nombre.isEmpty());
        System.out.printf("Por favor, escriba sus apellidos: ");
        apellidos = sc.nextLine();
        System.out.printf("Por favor, escriba su curso: ");
        curso = sc.nextLine();
        System.out.printf("Por favor, escriba su DNI: ");
        DNI = sc.nextLine();
        System.out.printf("Por favor, escriba su grupo de prácticas: ");
        grupoPracticas = sc.nextLine();
        do {
            numeroBien = false;
            do {
                System.out.printf("Por favor, escriba el número de calificaciones: ");
                temp = sc.nextLine();

            } while (temp.isEmpty());
            try {
                numNotas = Integer.parseInt(temp);
                numeroBien = true;
            } catch (Exception e) {
                System.out.printf("\nPerdón, ese número no es correcto. Pruebe de nuevo.\n");
                numeroBien = false;
            }
        } while (!numeroBien);
        calificaciones = new float[numNotas];
        for (int i = 0; i < numNotas; i++) {
            do {
                numeroBien = false;
                do {
                    System.out.printf(String.format("nota[%d] = ", i));
                    temp = sc.nextLine();

                } while (temp.isEmpty());
                try {
                    calificaciones[i] = Float.parseFloat(temp);
                    numeroBien = true;
                } catch (Exception e) {
                    System.out.printf("\nPerdón, esa nota no es correcto. Pruebe de nuevo.\n");
                    numeroBien = false;
                }
            } while (!numeroBien);
        }
        System.out.printf("Por favor, escriba sus comentarios: ");
        comentarios = sc.nextLine();
    }

    void leerDeTeclado2() {

        nombre = readString_ne("Por favor, escriba su nombre: ");
        apellidos = readString("Por favor, escriba sus apellidos: ");
        curso = readString("Por favor, escriba su curso: ");
        DNI = readString("Por favor, escriba su DNI: ");
        grupoPracticas = readString("Por favor, escriba su grupo de prácticas: ");
        numNotas = readInt("Por favor, escriba el número de calificaciones: ");
        calificaciones = new float[numNotas];
        for (int i = 0; i < numNotas; i++) {
            calificaciones[i] = readFloat(String.format("Nota[%d] = ", i));
        }
        comentarios = readString("Por favor, escriba sus comentarios: ");
    }

    void escribirEnPantalla() {
        System.out.printf("Nombre      :%20s%n", nombre);
        System.out.printf("Apellidos   :%20s%n", apellidos);
        System.out.printf("Curso       :%20s%n", curso);
        System.out.printf("DNI         :%20s%n", DNI);
        System.out.printf("Prácticas   :%20s%n", grupoPracticas);
        System.out.printf("Notas       :%20d%n", numNotas);
        for (float f : calificaciones) {
            System.out.printf("%33.2f%n", f);
        }
        System.out.printf("Comentarios :%20s%n",comentarios);

    }
}
