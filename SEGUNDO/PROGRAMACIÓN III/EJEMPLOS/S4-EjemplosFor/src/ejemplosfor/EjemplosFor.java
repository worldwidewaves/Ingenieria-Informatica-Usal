/*
 * Salamanca - Programación III - Grado de Ingeniería Informática
 * Permission is granted for non-commercial use
 * Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
 /*
Crear las tablas de multiplicar (hasta 10) con índices
Crear las tablas de multiplicar (hasta 10) sin índices
Sumar los n primeros números (500500) con y sin índices
 */
package ejemplosfor;

import java.util.stream.IntStream;
import static com.coti.tools.DiaUtil.*;

/**
 *
 * @author bruegel
 */
public class EjemplosFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
// Crear las tablas de multiplicar (hasta 10) con índices
        System.out.printf("Tablas de multiplicar con índices V0.9%n%n");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n%nTablas de multiplicar sin índices V1.0%n%n");
        // Versión con lista de enteros creada a mano
        // Hay más versiones, ver el tema de matrices
        //
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : numeros) {
            for (int j : numeros) {
                System.out.printf("%4d", i * j);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n%nTablas de multiplicar sin índices V2.0%n%n");

        for (int i : IntStream.range(1, 11).toArray()) {
            for (int j : IntStream.range(1, 11).toArray()) {
                System.out.printf("%4d", i * j);
            }
            System.out.printf("%n");
        }

        //
        // Show final time
        //
        showFinalTime();
    }

}
