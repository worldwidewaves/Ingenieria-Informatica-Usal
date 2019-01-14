package Ejercicio07;

import java.util.Scanner;
import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 07:
 * Se dispone de las notas de tres alumnos, cada uno de los cuales tiene una calificación del
 * primer parcial, segundo parcial y examen final. Se pide construir un programa que lea la
 * información de los tres alumnos a través del teclado, y que luego muestre las calificaciones y
 * la nota media en forma de tabla. Construir makefile y manifest.
 * @author Daniel García González
 */

public class Ejercicio07 {

    
    public static void main(String[] args) {
        float nota_1_p1, nota_1_p2, nota_1_p3;
        float nota_2_p1, nota_2_p2, nota_2_p3;
        float nota_3_p1, nota_3_p2, nota_3_p3;
        float media_1, media_2, media_3;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("%n|====================Cálculo de Nota Media====================|%n%n");
        
        /*=============================Recogida Datos==================================*/
        String temp;
        //Primero
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 1, 1);
        temp = sc.nextLine();
        nota_1_p1 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 1, 2);
        temp = sc.nextLine();
        nota_1_p2 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 1, 3);
        temp = sc.nextLine();
        nota_1_p3 = Float.parseFloat(temp);
        
        //Segundo
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 2, 1);
        temp = sc.nextLine();
        nota_2_p1 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 2, 2);
        temp = sc.nextLine();
        nota_2_p2 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 2, 3);
        temp = sc.nextLine();
        nota_2_p3 = Float.parseFloat(temp);
        
        //Tercero
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 3, 1);
        temp = sc.nextLine();
        nota_3_p1 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 3, 2);
        temp = sc.nextLine();
        nota_3_p2 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del " + "alumno %d, parcial %d : ", 3, 3);
        temp = sc.nextLine();
        nota_3_p3 = Float.parseFloat(temp);
        
        
        
        /*==========================Calcular Medias=================================*/
        media_1 = (nota_1_p1 + nota_1_p2 + nota_1_p3) / 3;
        media_2 = (nota_2_p1 + nota_2_p2 + nota_2_p3) / 3;
        media_3 = (nota_3_p1 + nota_3_p2 + nota_3_p3) / 3;
        
        
        
        /*==============================Mostrar Datos===============================*/
        System.out.printf("%nDatos introducidos:%n%n");
        System.out.printf("|%9s|%9s|%9s|%n","Parcial 1","Parcial 2","Parcial 3");
        System.out.printf("|%9.2f|%9.2f|%9.2f|%n", nota_1_p1, nota_1_p2, nota_1_p3);
        System.out.printf("|%9.2f|%9.2f|%9.2f|%n", nota_2_p1, nota_2_p2, nota_2_p3);
        System.out.printf("|%9.2f|%9.2f|%9.2f|%n", nota_3_p1, nota_3_p2, nota_3_p3);
        
        System.out.printf("%nMedia de cada alumno:%n%n");
        System.out.printf("La media del alumno %d es %6.2f%n", 1, media_1);
        System.out.printf("La media del alumno %d es %6.2f%n", 2, media_2);
        System.out.printf("La media del alumno %d es %6.2f%n", 3, media_3);
        
        
        showFinalTime();
    }
    
}
