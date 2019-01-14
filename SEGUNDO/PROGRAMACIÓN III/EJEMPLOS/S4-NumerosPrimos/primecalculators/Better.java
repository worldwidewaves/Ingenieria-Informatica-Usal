/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
package primecalculators;

import java.util.ArrayList;

public class Better {

    int lastCheckedNumber;

    public Better(int n) {
        this.lastCheckedNumber = n;
    }

    public boolean isPrime(int possiblePrimeNumber) {
        if (possiblePrimeNumber <= 3) {
            return true;
        }
        for (int divisor = 2; divisor < possiblePrimeNumber / 2; divisor++) {
            if (possiblePrimeNumber % divisor == 0) {
                return false;
            }
        }
        return true;
    }

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
        for (int i = 5; i <= lastCheckedNumber; i += 2) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    } // Fin de listaDePrimos()

} // Fin de Simple
