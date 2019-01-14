package javablooping04;

/**
 * JAVA BLOOBING 04: 
 * Write a program that prints a multiplication table for numbers up to 12.
 * 
 * @author Daniel García González
 */

public class JavaBlooping04 {
    public static void main(String[] args) {
        int N= 12;
        int x, y;
        
        //En vertical
        System.out.printf("Tabla de multiplicar de los numeros hasta el %d:%n"
                        + "================================================%n%n", N);
        for(x=0;x<=N;x++){
            System.out.printf(      "Tabla del %2d:%n"
                            +       "-------------%n", x);
            for(y=0;y<=10;y++){
                System.out.printf(  "%2d x %2d = %3d%n", x, y, x*y);
            }
            System.out.printf("%n%n");
        }
        
        //En horizontal
        System.out.printf("Tabla de multiplicar de los numeros hasta el %d:%n"
                        + "================================================%n", N);
        for(x=0;x<=N;x++){
            System.out.printf(      "Tabla del %2d:\t", x);
        }
        System.out.printf("%n");
        for(x=0;x<=N;x++){
            System.out.printf(      "-------------\t");
        }
        System.out.printf("%n");
        for(y=0;y<=10;y++){
            for(x=0;x<=N;x++){
                System.out.printf(  "%2d x %2d = %3d\t", x, y, x*y);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
        
    }
}