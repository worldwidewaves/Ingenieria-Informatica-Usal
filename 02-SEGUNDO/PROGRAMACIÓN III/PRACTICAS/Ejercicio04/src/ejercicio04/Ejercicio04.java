package ejercicio04;

import static com.coti.tools.DiaUtil.showFinalTime;
import java.util.Scanner;

/**
 * EJERCICIO 04:
 * Eany, Meany y Moe escriben en el ordenador sus nombres, edades y tallas. Hacer un
 * programa que muestre en forma de tabla sus nombres, edades y tallas (con los datos de cada
 * persona en una línea). Recordar que printf() funciona como en C.
 * @author Daniel García González
 */

public class Ejercicio04 {
    
    public static void main(String[] args) {
        String nombreEany, nombreMeany, nombreMoe;
        int edadEany, edadMeany, edadMoe;
        float tallaEany, tallaMeany, tallaMoe;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el nombre de Eany: ");
        nombreEany = sc.nextLine();
        System.out.println("Introduce el nombre de Meany: ");
        nombreMeany = sc.nextLine();
        System.out.println("Introduce el nombre de Moe: ");
        nombreMoe = sc.nextLine();
        
        System.out.println("Introduce la edad de Eany: ");
        edadEany = sc.nextInt();
        System.out.println("Introduce la edad de Meany: ");
        edadMeany = sc.nextInt();
        System.out.println("Introduce la edad de Moe: ");
        edadMoe = sc.nextInt();
        
        System.out.println("Introduce la talla de Eany: ");
        tallaEany = sc.nextFloat();
        System.out.println("Introduce la talla de Meany: ");
        tallaMeany = sc.nextFloat();
        System.out.println("Introduce la talla de Moe: ");
        tallaMoe = sc.nextFloat();
        
        //Si detrás de las edades o tallas hubiera que leer más strings habría que
        //desacerse del <enter> introducido al final poniendo "sc.nextLine()"
        System.out.printf("\n|%25s|%12s|%14s%n", "Nombre", "Edad", "Talla");
        System.out.printf("|%25s|%12d|%14.2f%n", nombreEany, edadEany, tallaEany);
        System.out.printf("|%25s|%12d|%14.2f%n", nombreMeany, edadMeany, tallaMeany);
        System.out.printf("|%25s|%12d|%14.2f%n", nombreMoe, edadMoe, tallaMoe);
        
        showFinalTime();
    }   
}
