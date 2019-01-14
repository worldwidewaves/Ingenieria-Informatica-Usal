/*
 *
 * Enunciado:
 *
 * Leer de teclado un número entero. Escribir el número en pantalla.
 *
 * Nota:
 *
 * Para compilar y ejecutar se pulsa F6 (fn + F6 en MacBook)
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero;
        System.out.print("Por favor, escriba un número entero: ");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();

        System.out.printf("El número que ha escrito es %d%n", numero);
        System.out.printf("%d en binario es %s%n", numero,
        						 Integer.toBinaryString(numero));
    }
}
