package javablooping05;

import java.util.ArrayList;

        
/**
 * JAVA BLOOBING 05: 
 * Write a program that prints all prime numbers. (Note: if your programming language does not
 * support arbitrary size numbers, printing all primes up to the largest number you can easily
 * represent is fine too.)
 * 
 * @author Daniel García González
 */

public class JavaBlooping05 {
    public static void main(String[] args) {
        int n= 1000;
        Optimized opt= new Optimized(n);
        
        ArrayList<Integer> primos = opt.listOfPrimeNumbers();

        System.out.printf("Los numeros primos del 0 al %d son:%n", n);
        for(int i : primos){
            System.out.printf("%d, " , i);
        }
    }
}
