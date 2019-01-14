package ejercicio02;

import java.io.Console;
import static com.coti.tools.DiaUtil.*;
import java.util.Scanner;

/**
 * EJERCICIO 02:
 * Una persona escribe en el ordenador su nombre y cada uno de sus dos apellidos. ¿Cual es la
 * longitud de cada uno? Usar el método length() de String. Hecho con Console y Scanner
 * @author Daniel García González
 */

public class Ejercicio02 {
    
    public static void main(String[] args) {
        int longitudNombreC, longitudApellido1C, longitudApellido2C;
        int longitudNombreS, longitudApellido1S, longitudApellido2S;
        String nombreC, apellido1C, apellido2C;
        String nombreS, apellido1S, apellido2S;
        Console c = System.console();
        Scanner sc = new Scanner(System.in);
        
        //Pedir [Console]
        System.out.println("Introduce tu nombre [Console]: ");
        nombreC = c.readLine();
        System.out.println("Introduce tu primer apellido [Console]: ");
        apellido1C = c.readLine();
        System.out.println("Introduce tu segundo apellido [Console]: ");
        apellido2C = c.readLine();
        
        //Separardor
        System.out.printf("%n");
        
        //Pedir [Scanner]
        System.out.println("Introduce tu nombre [Scanner]: ");
        nombreS = sc.nextLine();
        System.out.println("Introduce tu primer apellido [Scanner]: ");
        apellido1S = sc.nextLine();
        System.out.println("Introduce tu segundo apellido [Scanner]: ");
        apellido2S = sc.nextLine();
        
        //Longitud [Console]
        longitudNombreC= nombreC.length();
        longitudApellido1C= apellido1C.length();
        longitudApellido2C= apellido2C.length();
        
        //Longitud [Scanner]
        longitudNombreS = nombreS.length();
        longitudApellido1S = apellido1S.length();
        longitudApellido2S = apellido2S.length();
        
        //Separador
        System.out.printf("%n%n");
        
        //Mostrar [Console]
        System.out.printf("Con [Console]:%n");
        System.out.printf("La longitud de tu nombre y apellidos es: %d%n", longitudNombreC + longitudApellido1C + longitudApellido2C);
        System.out.printf("Nombre [%s]: %d%n", nombreC, longitudNombreC);
        System.out.printf("Primer apellido [%s]: %d%n", apellido1C, longitudApellido1C);
        System.out.printf("Segundo apellido [%s]: %d%n", apellido2C, longitudApellido2C);
        System.out.printf("%n%n");
        
        System.out.printf("Con [Scanner]:%n");
        System.out.println("Su nombre es " + nombreS + " " + apellido1S + " " + apellido2S);
        System.out.print("La longitud de " + nombreS + " es " + nombreS.length() + "\n");
        System.out.print("La longitud de " + apellido1S + " es " + apellido1S.length() + "\n");
        System.out.print("La longitud de " + apellido2S + " es " + apellido2S.length() + "\n");
        System.out.printf("%n%n");
    
        showFinalTime();
    } 
}
