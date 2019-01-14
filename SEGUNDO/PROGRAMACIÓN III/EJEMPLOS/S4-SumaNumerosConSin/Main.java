/*
 
 ENUNCIADO:
 
 Calcula la suma de los n primeros números con índices y sin índices
 
 */
import java.util.Scanner;
import java.time.LocalTime;
import calculadoras.SinIndices;
import calculadoras.ConIndices;
import static com.coti.tools.DiaUtil.*;

public class Main {
  
  public static void main(String[] args) {
    //
    // Declaración de variables
    //
    ConIndices con = new ConIndices(100);
    SinIndices sin = new SinIndices(100);
    //
    // Procesamiento
    //
    
    //
    // Impresión de resultados
    //
    System.out.printf("%nCálculo con índices:%n%n");
    con.calcularSuma();
    con.mostrarResultado();
    System.out.printf("Cálculo sin índices:%n%n");
    sin.calcularSuma();
    sin.mostrarResultado();
    //
    // Terminación del programa
    //
    showFinalTime();
  } // Fin de main()
  
} // Fin de Main
