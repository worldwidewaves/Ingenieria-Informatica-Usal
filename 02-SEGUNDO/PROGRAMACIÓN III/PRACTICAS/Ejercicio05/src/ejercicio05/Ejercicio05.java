package ejercicio05;

import static com.coti.tools.DiaUtil.showFinalTime;
import java.util.Scanner;

/**
 * EJERCICIO 05:
 * Tom, Dick y Harry introducen sus pesos y tallas en el ordenador. ¿Quien es el más alto?
 * ¿Quién pesa mas? Consultar al profesor el uso de la sentencia if-else.
 * @author Daniel García González
 */

public class Ejercicio05 {

    public static void main(String[] args) {
        float pesoTom, pesoDick, pesoHarry;
        float pesoMayor;
        double tallaTom, tallaDick, tallaHarry;
        String nombrePesoMayor;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el peso de Tom: ");
        pesoTom = sc.nextFloat();
        pesoMayor = pesoTom;
        nombrePesoMayor = "Tom";
        System.out.println("Introduce el peso de Dick: ");
        pesoDick = sc.nextFloat();
        if (pesoMayor < pesoDick){
            pesoMayor = pesoDick;
            nombrePesoMayor = "Dick";
        }
        System.out.println("Introduce el peso de Harry: ");
        pesoHarry = sc.nextFloat();
        if (pesoMayor < pesoHarry){
            pesoMayor = pesoHarry;
            nombrePesoMayor = "Harry";
        }
        
        System.out.println("Introduce la talla de Tom: ");
        tallaTom = sc.nextDouble();
        System.out.println("Introduce la talla de Dick: ");
        tallaDick = sc.nextDouble();
        System.out.println("Introduce la talla de Harry: ");
        tallaHarry = sc.nextDouble();
        
        
    /*    if ((pesoTom > pesoDick) && (pesoTom > pesoHarry)){
            System.out.println("Harry es el de mayor peso.");
        }
        else if ((pesoTom < pesoDick) && (pesoDick > pesoHarry)){
            System.out.println("Dick es el de mayor peso.");
        }
        else{
            System.out.println("Harry es el de mayor peso.");
        }
     */
    
        System.out.println("El de mayor peso es: " + nombrePesoMayor);
    
        if ((tallaTom > tallaDick) && (tallaTom > tallaHarry)){
            System.out.println("Harry es el más alto.");
        }
        else if ((tallaTom < tallaDick) && (tallaDick > tallaHarry)){
            System.out.println("Dick es el de más alto.");
        }
        else{
            System.out.println("Harry es el más alto.");
        }
        
        showFinalTime();
    }
    
}
