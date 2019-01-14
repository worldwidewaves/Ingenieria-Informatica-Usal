package ejercicio03;

import java.util.Scanner;
import static com.coti.tools.DiaUtil.*;

/**
 * EJERCICIO 03:
 * Un entrenador escribe en el ordenador los resultados de los diez últimos partidos (el número
 * de goles que ha metido su equipo). ¿Cual es el goal average del equipo?
 * @author Daniel García González
 */

public class Ejercicio03 {
    
    public static void main(String[] args) {
        int g1, g2, g3, g4, g5, g6, g7, g8, g9, g10;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el número de goles del 1er partido: ");
        g1 = sc.nextInt();
        System.out.println("Introduce el número de goles del 2do partido: ");
        g2 = sc.nextInt();
        System.out.println("Introduce el número de goles del 3er partido: ");
        g3 = sc.nextInt();
        System.out.println("Introduce el número de goles del 4to partido: ");
        g4 = sc.nextInt();
        System.out.println("Introduce el número de goles del 5to partido: ");
        g5 = sc.nextInt();
        System.out.println("Introduce el número de goles del 6to partido: ");
        g6 = sc.nextInt();
        System.out.println("Introduce el número de goles del 7mo partido: ");
        g7 = sc.nextInt();
        System.out.println("Introduce el número de goles del 8vo partido: ");
        g8 = sc.nextInt();
        System.out.println("Introduce el número de goles del 9no partido: ");
        g9 = sc.nextInt();
        System.out.println("Introduce el número de goles del 10mo partido: ");
        g10 = sc.nextInt();
        System.out.printf("%n");
        
        System.out.print("La media de goles del equipo es " + (g1+g2+g3+g4+g5+g6+g7+g8+g9+g10)/10.00f + "\n");
        
        
        showFinalTime();
    }
    
}

