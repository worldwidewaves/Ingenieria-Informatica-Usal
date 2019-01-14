/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodeclaseabstracta;

/**
 *
 * @author Tests by coti
 */
public class ClaseConcreta extends ClaseAbstracta {
int tocameroque;
    @Override
    public void metodoAbstracto() {
        System.out.println("Este método es abstracto en su origen, y se ha");
        System.out.println("implementado en ClaseConcreta.\n\n");
        System.out.println(s);
    }
    
}
