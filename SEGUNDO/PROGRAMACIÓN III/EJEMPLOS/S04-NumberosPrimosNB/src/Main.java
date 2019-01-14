/*
 * Universidad de Salamanca - Depto de Informática y Automática
 * Grado en Ingeniería Informática - Programación III 2016-2017
 * Copyright (C) Dr. J.R. García-Bermejo Giner - coti@usal.es
 */

/**
 *
 * @author coti
 */
/*
 
 ENUNCIADO:
 
 
 */
import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;

import primecalculators.*;

import static com.coti.tools.DiaUtil.*;

public class Main {

    public static void main(String[] args) {
        //
        // Declaración de variables
        //
        Good good = new Good(10000);
        Better better = new Better(10000);
        Optimized optimized = new Optimized(10000);

        ArrayList<Integer> temp;
        //
        // Procesamiento
        //
        startTimer();
        temp = good.listOfPrimeNumbers();
        stopTimerAndPrintElapsedTimeMillis();

        System.out.printf("%nCalculador Simple: %d primos hallados%n", temp.size());
        System.out.printf("Simple%n%n");
        System.out.println(temp);
        temp.clear();

        startTimer();
        temp = better.listOfPrimeNumbers();
        stopTimerAndPrintElapsedTimeMillis();

        System.out.printf("%nCalculador Bueno: %d primos hallados%n", temp.size());
        System.out.printf("Good%n%n");
        System.out.println(temp);
        temp.clear();

        startTimer();
        temp = optimized.listOfPrimeNumbers();
        stopTimerAndPrintElapsedTimeMillis();

        System.out.printf("%nCalculador Optimizado: %d primos hallados%n", temp.size());
        System.out.printf("Better%n%n");
        System.out.println(temp);

        //
        // Terminación del programa
        //
        showFinalTime();

    } // Fin de main()

} // Fin de Main
