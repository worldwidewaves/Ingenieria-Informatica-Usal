package javablooping03;

import java.util.Scanner;

/**
 * JAVA BLOOBING 03: 
 * Write a program that asks the user for a number n and gives him the possibility to choose betweenc 
 * computing the sum and computing the product of 1,…,n. 
 * 
 * @author Daniel García González
 */

public class JavaBlooping03 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n;
        int modo;
        int suma= 0;
        double producto= 1;
        
        //Petición n
        System.out.printf("Introduce un valor para n: ");
        n= sc.nextInt();
        
        //Petición modo
        do{
            System.out.printf("Introduce un modo: %n"
                            + "1) Suma.%n"
                            + "2) Producto.%n"
                            + "3) Ambas.%n"
                            + "Opción: ");
            modo= sc.nextInt();
            sc.nextLine();
        } while(modo!=1 && modo!=2 && modo!=3);
        System.out.printf("%n");
        
        //Suma
        if(modo==1 || modo==3){
            for (int i=0; i<=n; i++){
                suma+= i;
            }
            System.out.printf("La suma vale: %d%n", suma);
        }
        
        //Producto
        if(modo==2 || modo==3){
            for (int i=1; i<=n; i++){
                producto*= i;
            }
            System.out.printf("El producto vale: %.0f%n", producto);
        }
    }
}
