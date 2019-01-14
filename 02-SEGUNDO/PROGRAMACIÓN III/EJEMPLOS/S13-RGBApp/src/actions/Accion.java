/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import mainpackage.Model;

/**
 *
 * @author coti
 */
public abstract class Accion {

    private Model modelo;

    public Accion() {
        modelo = null;
    }

    /**
     * @return the modelo
     */
    public Model getModelo() {
        return modelo;
    }

    public void setModelo(Model _m) {
        modelo = _m;
    }

    public abstract void run();
}
