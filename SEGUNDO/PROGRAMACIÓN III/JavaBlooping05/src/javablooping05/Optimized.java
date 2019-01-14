package javablooping05;

import java.util.ArrayList;


public class Optimized {
    int lastNumberToBeChecked;
    
    
    public Optimized(int n) { 
        this.lastNumberToBeChecked = n; 
    }
    
    
    public boolean isPrime(int possiblePrime) {
        if (possiblePrime <= 3) { return true; }
        //
        // The biggest divisor cannot be bigger than the square root of the number
        long biggestPossibleDivisor = Math.round(Math.sqrt(possiblePrime));
        for (int divisor = 3; divisor <= biggestPossibleDivisor; divisor++) {
        if (possiblePrime % divisor == 0) { return false; }
        }
        return true;
    }
    
    
    // Check only numbers from 5 on, and indeed only even numbers (5, 7, 9 etc).
    public ArrayList<Integer> listOfPrimeNumbers() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        
        for (int i = 5; i <= lastNumberToBeChecked; i += 2) {
            if (isPrime(i)) { result.add(i); }
        }
        return result;
    } // Fin de listaDePrimos()
} // Fin de Optimized