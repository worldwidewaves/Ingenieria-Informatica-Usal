package Ejercicio09;

import java.util.Scanner;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 09:
 * Escribir un programa que lea el nombre del usuario y luego lo imprima en pantalla dos veces,
 * una ajustado a la izquierda y otra ajustado a la derecha (ambas en 20 columnas). Usar
 * Scanner y System.out.printf().
 * @author Daniel García González
 */

public class Ejercicio09 {

    public static void main(String[] args) {
        String nombre;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce tu nombre: ");
        nombre = sc.nextLine();
        
        System.out.printf("%n%20s%n", nombre);
        System.out.printf("%-20s%n", nombre);
        
        showFinalTime();
    }
    
}
