/*
 * 
 * Enunciado:
 * 
 * Leer tres números de coma flotante y calcular su media.
 * 
 * 
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float n1, n2, n3;
        System.out.print("Escriba tres números: ");
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextFloat();
        n2 = sc.nextFloat();
        n3 = sc.nextFloat();
        float media = (n1+n2+n3)/3.0f;
        System.out.printf("La media de %.1f, %.1f y %.1f es %.2f%n", n1, n2, n3, media);
    }
}










