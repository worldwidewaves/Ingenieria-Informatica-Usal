//afdasfdasf¡'09
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Principal {

  public static void main(String[] args) {
    System.out.printf("%nDiez alumnos iguales%n%n");
    // Se crea una lista de alumnos (ojo, está vacía aún)
    Alumno[] lista = new Alumno[10];
    // Se crean diez alumnos con el ctor sin argumentos
    for(int i=0; i<lista.length; i++) {
      lista[i] = new Alumno();
      System.out.println(lista[i]);
    }
    
    // Creamos unos valores de asistencia aleatorios
    boolean[] temp = new boolean[15];
    Random r = new Random();

    System.out.printf("%n%nDiez alumnos con asistencias aleatorias%n%n");
    for (int i=0;i < lista.length;i++) {
      
      for(int j=0; j< temp.length; j++) {
        temp[j] = r.nextBoolean();
      }
      lista[i] = new Alumno("José", "García", "López", "555333",temp);
      
      System.out.println(lista[i]);
    }
  } // Fin del método main()
} // Fin de Principal
