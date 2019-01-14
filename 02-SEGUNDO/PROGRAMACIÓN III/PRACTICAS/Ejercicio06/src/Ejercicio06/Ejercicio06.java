package Ejercicio06;

import java.util.Scanner;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 06:
 * Escribir un programa que calcule el precio final que pagará un cliente en una frutería, que sólo
 * trabaja con peras y manzanas. Se pedirá la cantidad de peras y manzanas y los precios por
 * kilo, sin IVA. Se mostrará el total sin IVA, el IVA y el total con IVA.
 * @author Daniel García González
 */

public class Ejercicio06 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float kilosPeras, kilosManzanas;
        float precioDelKiloPeras, precioDelKiloManzanas;
        float totalSinIva, totalConIva;
        float ivaPagado;
        float IVA_FRUTA = 0.15f;
        String temp;
        
        System.out.printf("Frutería Mary%n===============%n%n");
        
        //Peras
        System.out.println("¿Cuántos kilos de peras deseas?");
        temp = sc.nextLine();
        kilosPeras = Float.parseFloat(temp);
        
        System.out.println("¿Cuántos vale el kilo de peras?");
        temp = sc.nextLine();
        precioDelKiloPeras = Float.parseFloat(temp);
        
        System.out.printf("%n");
        
        //Manzanas
        System.out.println("¿Cuántos kilos de manzanas deseas?");
        temp = sc.nextLine();
        kilosManzanas = Float.parseFloat(temp);
        
        System.out.println("¿Cuántos vale el kilo de manzanas?");
        temp = sc.nextLine();
        precioDelKiloManzanas = Float.parseFloat(temp);
        
        totalSinIva = (kilosManzanas * precioDelKiloManzanas) + (kilosPeras * precioDelKiloPeras);
        ivaPagado = totalSinIva * IVA_FRUTA;
        totalConIva = totalSinIva + ivaPagado;
        
        
        System.out.printf("%nSin IVA:    %8.2f", totalSinIva);
        System.out.printf("%nIVA pagado: %8.2f [%2.0f%%]", ivaPagado, IVA_FRUTA * 100);
        System.out.printf("%nCon IVA:    %8.2f", totalConIva);
        
       
       showFinalTime();
    }
    
}
