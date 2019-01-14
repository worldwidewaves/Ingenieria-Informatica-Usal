/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
package primecalculators;

import java.util.ArrayList;

public class Optimized {

    int lastNumberToBeChecked;

    public Optimized(int n) {
        this.lastNumberToBeChecked = n;
    }

    public boolean isPrime(int possiblePrime) {
        if (possiblePrime <= 3) {
            return true;
        }
        //
        // The biggest divisor cannot be bigger than the square rooto of the number
        // This is a tremendous optimisation
        //
        long biggestPossibleDivisor = Math.round(Math.sqrt(possiblePrime));
        for (int divisor = 3; divisor <= biggestPossibleDivisor; divisor++) {
            if (possiblePrime % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    //
    // Check only numbers from 5 on, and indeed only even numbers (5, 7, 9 etc).
    // This optimisation cuts the number of checked numbers in half
    //
    public ArrayList<Integer> listOfPrimeNumbers() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        //
        // We know 1 is prime, as well as 2 and 3. 4 is not. Hence we start on 5
        //
        // Further, we directly do not check even numbers
        //
        for (int i = 5; i <= lastNumberToBeChecked; i += 2) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    } // Fin de listaDePrimos()

} // Fin de Simple
