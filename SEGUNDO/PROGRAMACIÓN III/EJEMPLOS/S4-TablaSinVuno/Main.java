/*
 
 ENUNCIADO:
 
 Crear una tabla de multiplicar sin índices
 
 */
import java.util.Scanner;
import java.util.stream.IntStream;
import java.time.LocalTime;
import static com.coti.tools.DiaUtil.*;

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
       System.out.printf("%n%nTablas de multiplicar sin índices V2.0%n%n");

    int[] numeros = IntStream.rangeClosed(1, 10).toArray();
        for (int i : numeros) {
            for (int j : numeros) {
                System.out.printf("%4d", i * j);
            }
            System.out.printf("%n");
        }
    
    //
    // Terminación del programa
    //
    showFinalTime();
  } // Fin de main()
  
} // Fin de Main
