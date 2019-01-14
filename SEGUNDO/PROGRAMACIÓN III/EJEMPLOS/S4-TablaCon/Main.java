/*
 
 ENUNCIADO:
 
 Crear las tablas de multiplicar hasta 10 (con índices)
 
 */
import java.util.Scanner;
import com.coti.tools.DiaUtil;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        //
        // Declaración de variables
        //

        //
        // Procesamiento
        //
        //
        // Impresión de resultados
        //
        System.out.printf("Tablas de multiplicar hasta 10. Version 1.0%n%n");

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.printf("%n");
        }

        //
        // Terminación del programa
        //
        DiaUtil.showFinalTime();
    } // Fin de main()

} // Fin de Main
