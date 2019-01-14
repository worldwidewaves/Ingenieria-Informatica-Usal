/*
 * 
 * Enunciado:
 * 
 * Leer dos números enteros y mostrar su suma.
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n1, n2, n3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, escriba dos números: ");
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = n1 + n2;
        System.out.printf("La suma de %d y %d es %d%n", n1, n2, n3);
    }
}
