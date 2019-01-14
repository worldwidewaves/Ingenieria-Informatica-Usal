/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package composicionyherencia;

/**
 *
 * @author Tests by coti
 */
public class Composicion_y_Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Empleado e1 = new Empleado("Juan Pérez", "Calle del Pez 13");
        Empleado e2 = new Empleado("Ana García", "13 Rue du Percebe");
        
        Comercial c1 = new Comercial("José García", "Roßauerlände 88", 33.0f, 22.0f);
        Comercial c2 = new Comercial("Francis Drake", "Whitehall", 44.0f, 10.0f);
        
        Administrativo ad1 = new Administrativo("John Doe", "222B Baker Street", "Limpieza");
        Administrativo ad2 = new Administrativo("Jane Roe", "Montparnasse 99", "Contubernios");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(ad1);
        System.out.println(ad2);
        System.out.println(c1);
        System.out.println(c2);

        Corruto angelito = new Corruto("No Body", "No house", 4234234.0f, 342434124124.0f, 0.03f);
        System.out.println(angelito);
    }
}
