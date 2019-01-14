package ejercicio02b;

import static com.coti.tools.DiaUtil.showFinalTime;
import java.util.Scanner;

/**
 * EJERCICIO 02b:
 * Escribir un programa que pida el año de nacimiento de una persona y el año actual.
 * Suponiendo que ya ha cumplido años, se calculará la edad.
 * @author Daniel García González
 */

public class Ejercicio02b {

    public static void main(String[] args) {
        int annioActual, annioUser, edad;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce tus año de nacimiento: ");
        annioUser = sc.nextInt();
        System.out.println("Introduce el año actual: ");
        annioActual = sc.nextInt();
       
        edad =  annioActual - annioUser;
        System.out.print("\nTus años son " + edad);
        
        showFinalTime();
    }
}
