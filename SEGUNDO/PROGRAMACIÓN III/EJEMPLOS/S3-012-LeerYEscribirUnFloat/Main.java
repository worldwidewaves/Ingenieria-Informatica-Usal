/*
 * 
 * Enunciado:
 * 
 * Leer de teclado un número de coma flotante de algún tipo.
 * Escribir el número en pantalla.
 * 
 * Nota:
 * 
 * Source->Format es Ctrl-Mayúsculas-F
 * 
 * Resultado:
 * 
 * Por favor, escriba dos números: 1234,5678901234567890 1234,5678901234567890
 * El primer  número que ha escrito era 1234,5679
 * El segundo número que ha escrito era 1234,56789012
 * 
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float unNumero;
        double otroNumero;
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, escriba dos números: ");
        unNumero = sc.nextFloat();
        otroNumero = sc.nextDouble();
        System.out.printf("El primer  número que ha escrito era %6.4f%n", unNumero);
        System.out.printf("El segundo número que ha escrito era %6.8f%n", otroNumero);
    }
}
