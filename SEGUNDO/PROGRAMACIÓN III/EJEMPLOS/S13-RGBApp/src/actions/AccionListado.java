package actions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coti
 */
public class AccionListado extends Accion {

    public AccionListado() {
        super();
    }
    
    @Override
    public void run() {
        if (this.getModelo().size() == 0) {
            System.out.println("\nLa base de datos no contiene registros.\n");
            return;
        }
        System.out.println("\nListado:\n");
        this.getModelo().showContents();
    }
}
