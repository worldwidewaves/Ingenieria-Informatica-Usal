package Ejercicio08;

import static com.coti.tools.DiaUtil.showFinalTime;

/**
 * EJERCICIO 08:
 * Se dispone de las notas de tres alumnos, cada uno de los cuales tiene una calificación del
 * primer parcial, segundo parcial y examen final. Se pide construir un programa que tome la
 * información de los alumnos a partir de la línea de órdenes (nueve datos en total) y que luego
 * muestre las calificaciones y la nota media en forma de tabla.
 * @author Daniel García González
 */

public class Ejercicio08 {
    
    public static void main(String[] args) {
        float nota_1_p1, nota_1_p2, nota_1_p3;
        float nota_2_p1, nota_2_p2, nota_2_p3;
        float nota_3_p1, nota_3_p2, nota_3_p3;
        float media_1, media_2, media_3;
        
        
        /*=====================Comprobación Nº Argumentos===================*/
        if(args.length != 9){
            System.out.println("Numero de argumentos incorrecto.");
            System.exit(0);
        }
        
        /*=========================Asignación Valores=======================*/
        //Primero
        nota_1_p1 = Float.parseFloat(args[0]);
        nota_1_p2 = Float.parseFloat(args[1]);
        nota_1_p3 = Float.parseFloat(args[2]);
        
        //Segundo
        nota_2_p1 = Float.parseFloat(args[3]);
        nota_2_p2 = Float.parseFloat(args[4]);
        nota_2_p3 = Float.parseFloat(args[5]);
        
        //Tercero
        nota_3_p1 = Float.parseFloat(args[6]);
        nota_3_p2 = Float.parseFloat(args[7]);
        nota_3_p3 = Float.parseFloat(args[8]);
                
                
        System.out.printf("%n|====================Cálculo de Nota Media====================|%n%n");
        
        
        
        /*==========================Calcular Medias=================================*/
        media_1 = (nota_1_p1 + nota_1_p2 + nota_1_p3) / 3.0f;
        media_2 = (nota_2_p1 + nota_2_p2 + nota_2_p3) / 3.0f;
        media_3 = (nota_3_p1 + nota_3_p2 + nota_3_p3) / 3.0f;
        
        
        
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
