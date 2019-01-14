/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;
import mainpackage.BaseRecord;
/**
 *
 * @author coti
 */
public class AccionAltas extends Accion {

    public AccionAltas(){
        super();
    }

    @Override
    public void run() {
        System.out.println("\nAltas: escriba los datos de una persona.");
        BaseRecord p = new BaseRecord();
        p.readFromKeyboard();
        this.getModelo().add(p);
        System.out.println("Altas: datos añadidos.\n");
    }
    
}
