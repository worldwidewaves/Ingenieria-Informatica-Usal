/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punterosyherenciajava;

/**
 *
 * @author Tests by coti
 */
public class PunterosYHerenciaJava {

    /**
     * @param args the command line arguments
 
 1.- Se puede almacenar en un puntero de clase base la dirección de un
 puntero de clase derivada. Caso extremo: pB4 = new DDD().
 
 2.- El tipo del puntero determina el acceso a las características. Pej,
 un pB4 solo permite acceder al metodo_clase_base(), mientras que un
 pDDD permite acceder a todos los métodos heredados, así como al definido
 en la última clase derivada.
     * 
     */
    public static void main(String[] args) {
        // Este proyecto no hace nada, pero lo hace muy bien!
        B pB4 = new DDD();
        D pD3 = new DDD();
        DD pDD2 = new DDD();
        DDD pDDD = new DDD();
        // Esto no se puede hacer
        //DDD pDDD = new B();
        
        System.out.println("Caso de un pBase que apunta a una ClaseDerivadaDerivadaDerivada:\n");
        // Sólo se puede acceder al metodo_clase_base(), prima el tipo del puntero
        pB4.metodo_clase_base();


        System.out.println("\nCaso de un pD que apunta a una ClaseDerivadaDerivadaDerivada:\n");
        // Se puede acceder al método de la clase base y de la clase derivada
        pD3.metodo_clase_base();
        pD3.metodo_clase_derivada();

        System.out.println("\nCaso de un pDD que apunta a una ClaseDerivadaDerivadaDerivada:\n");
        // Se puede acceder al método de la clase base y de la clase derivada
        pDD2.metodo_clase_base();
        pDD2.metodo_clase_derivada();
        pDD2.metodo_clase_derivada_derivada();

        System.out.println("\nCaso de un pDD que apunta a una ClaseDerivadaDerivadaDerivada:\n");
        pDDD.metodo_clase_base();
        pDDD.metodo_clase_derivada();
        pDDD.metodo_clase_derivada_derivada();
        pDDD.metodo_clase_derivada_derivada_derivada();


    }
}
