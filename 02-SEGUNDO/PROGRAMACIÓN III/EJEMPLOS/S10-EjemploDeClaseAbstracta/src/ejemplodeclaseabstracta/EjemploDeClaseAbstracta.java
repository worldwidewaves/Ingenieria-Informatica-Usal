/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodeclaseabstracta;

/**
 *
 * @author Tests by coti
 */
public class EjemploDeClaseAbstracta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Este proyecto no hace nada, pero lo hace muy bien!
        ClaseAbstracta ca;
        //ca = new ClaseAbstracta(); //No se puede instanciar
        ClaseConcreta cc;
        cc = new ClaseConcreta();
        cc.metodoAbstracto();
        cc.metodoConcreto();
        System.out.println("\n\nHacemos ca = cc;\n\n");
        ca = cc;
        ca.metodoAbstracto();
        ca.metodoConcreto();
        System.out.println("\n\nUn descriptor de clase base admite como valor"+
                "la dirección de cualquier clase derivada.");
        
    }
}
