/*
 
 ENUNCIADO:
 
 
 */
import java.util.Scanner;
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
        System.out.printf("%n%nTablas de multiplicar sin índices Vcero%n%n");
        // Versión con lista de enteros creada a mano
        // Hay más versiones, ver el tema de matrices
        //
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
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
