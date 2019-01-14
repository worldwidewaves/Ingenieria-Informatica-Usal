/*
 * 
 * Enunciado:
 * 
 * Leer del teclado una cadena de cualquier longitud.
 * Mostrar en pantalla la cadena anterior. ¿Qué longitud tiene?
 * 
 * Nota:
 * 
 * Source->Fix imports es Cmd+Mayús+I
 * 
 */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String cadena;
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, escriba una frase: ");
        cadena = sc.nextLine();
        System.out.println("La cadena leída es " + cadena);
        System.out.printf("La longitud de %s es %d%n",
         cadena, cadena.length());
    }
}



