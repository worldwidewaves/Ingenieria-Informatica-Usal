package ejercicio10y11;

import java.util.Scanner;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 10:
 * Empleando los métodos parseXXX de las clases de envoltorio vistas anteriormente,
 * construir una clase dotada de métodos adecuados para leer todos los tipos de datos
 * numéricos (int, float, double) en forma de cadenas. Si el usuario no inserta un
 * valor correcto, pedir de nuevo el valor. (Dificil)
 * ------------------------------------------------------------------------------------
 * EJERCICIO 11:
 * Aplicar los métodos de la clase anterior a un programa pide a través del teclado los
 * datos de un ejemplar de Persona para después mostrar el estado de ese ejemplar
 * en pantalla. La clase Persona tiene como datos el nombre, la talla la edad de una
 * persona. Prohibir las tallas negativas y las edades mayores que 100 años. (Dificil)
 * @author Daniel García González
 */

public class Ejercicio10y11 {

    public static void main(String[] args) {
        int edadMin = 0, edadMax = 100;
        float tallaMin = 0.00f, tallaMax = 3.00f;
        
        Persona p = new Persona();
        p.setNombre("Ana");
        p.setEdad(21);
        p.setTalla(1.57f);
        System.out.println(p.getNombre() + " " + p.getEdad() + " " + p.getTall());
        
        Persona p2 = new Persona("Alba", 31, 1.72f);
        System.out.println(p2.getNombre()+ " " + p2.getEdad() + " " + p2.getTall());
       
        
        
        Scanner sc= new Scanner(System.in);
        String miNombre;
        int miEdad;
        float  miTalla;
        Lector lect= new Lector();
        
        System.out.println("Nombre: ");
        miNombre=sc.nextLine();
        miEdad=lect.leerInt("Edad",edadMin,edadMax);
        miTalla=lect.leerFloat("Talla",tallaMin,tallaMax);
        
        System.out.printf("%nNombre: %s%n", miNombre);
        System.out.printf("Edad: %d%n", miEdad);
        System.out.printf("Talla: %1.2f%n", miTalla);
        
        
        showFinalTime();
    }
    
}
